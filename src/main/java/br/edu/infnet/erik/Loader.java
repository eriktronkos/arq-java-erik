package br.edu.infnet.erik;

import br.edu.infnet.erik.model.domain.*;
import br.edu.infnet.erik.model.service.EmpresaService;
import br.edu.infnet.erik.model.service.StakeholderService;
import br.edu.infnet.erik.model.service.TituloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Component
public class Loader implements ApplicationRunner {

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private TituloService tituloService;

    @Autowired
    private StakeholderService stakeholderService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("files/empresas.txt");
        BufferedReader reader = new BufferedReader(file);

        String linha = reader.readLine();

        while (linha != null) {

            String[] campos = linha.split(";");

            switch (campos[0].toUpperCase()) {
                case "E":

                    Empresa empresa = new Empresa();
                    empresa.setCnpj(campos[1]);
                    empresa.setNome(campos[2]);
                    empresa.setEndereco(new Endereco(campos[3]));
                    empresaService.incluir(empresa);
                    break;

                case "S":

                    Stakeholder stakeholder = new Stakeholder();

                    stakeholder.setTipoPessoa(TipoPessoa.valueOf(campos[1]));
                    stakeholder.setCadastroPessoa(campos[2]);
                    stakeholder.setNome(campos[3]);
                    stakeholder.setEndereco(new Endereco(campos[4]));

                    stakeholderService.incluir(stakeholder);

                    break;

                case "A":
                    Acao acao = new Acao();

                    System.out.println(campos[0]);
                    System.out.println(campos[1]);
                    System.out.println(campos[2]);
                    System.out.println(campos[3]);

                    String cnpjEmpresaAcao = campos[1];
                    String identificadorStakeholderAcao = campos[2];
                    acao.setBaseCusto(BigDecimal.valueOf(Double.parseDouble(campos[3])));

                    Empresa empresaAcao = empresaService.obterPorCpnj(cnpjEmpresaAcao);
                    Stakeholder stakeholderAcao = stakeholderService.obterPorCadastroPessoal(identificadorStakeholderAcao);

                    acao.setEmpresa(empresaAcao);
                    acao.setStakeholder(stakeholderAcao);

                    tituloService.incluir(acao);

                    break;

                case "O":

                    Opcao opcao = new Opcao();
                    String cnpjEmpresaOpcao = campos[1];
                    String identificadorStakeholderOpcao = campos[2];
                    opcao.setCustoExercicio(BigDecimal.valueOf(Double.parseDouble(campos[3])));
                    DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    opcao.setDataVesting(sdf.parse(campos[4]));
                    opcao.setExercicioAntecipado(Boolean.parseBoolean(campos[5]));

                    Empresa empresaOpcao = empresaService.obterPorCpnj(cnpjEmpresaOpcao);
                    Stakeholder stakeholderOpcao = stakeholderService.obterPorCadastroPessoal(identificadorStakeholderOpcao);

                    opcao.setEmpresa(empresaOpcao);
                    opcao.setStakeholder(stakeholderOpcao);

                    tituloService.incluir(opcao);
                    break;


                default:
                    break;
            }

            linha = reader.readLine();
        }

        for (Empresa e : empresaService.obterLista()) {
            System.out.println("Empresa cadastrada com sucesso: " + e);
        }

        for (Stakeholder s : stakeholderService.obterLista()) {
            System.out.println("Stakeholder cadastrado com sucesso: " + s);
        }

        for (Titulo t : tituloService.obterLista()) {
            System.out.println("Titulo cadastrado com sucesso: " + t);
        }

        reader.close();
    }
}