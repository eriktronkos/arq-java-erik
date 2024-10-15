package br.edu.infnet.erik;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import br.edu.infnet.erik.model.domain.*;
import br.edu.infnet.erik.model.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Loader implements ApplicationRunner {

    @Autowired
    private EmpresaService empresaService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("files/empresas.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        Empresa empresa = null;
        Titulo titulo = null;

        while(linha != null) {

            String[] campos = linha.split(";");

            switch (campos[0].toUpperCase()) {
                case "E":

                    empresa = new Empresa();
                    empresa.setCnpj(campos[1]);
                    empresa.setNome(campos[2]);
                    empresaService.incluir(empresa);
                    break;

                case "A":
                    titulo = new Acao();

                    titulo.setId(Long.parseLong(campos[1]));
                    ((Acao) titulo).setBaseCusto(BigDecimal.valueOf(Double.parseDouble(campos[2])));

                    empresa.getTitulos().add(titulo);

                    break;

                case "O":

                    titulo = new Opcao();
                    titulo.setId(Long.parseLong(campos[1]));
                    ((Opcao) titulo).setCustoExercicio(BigDecimal.valueOf(Double.parseDouble(campos[2])));
                    DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    ((Opcao) titulo).setDataVesting(sdf.parse(campos[3]));
                    ((Opcao) titulo).setExercicioAntecipado(Boolean.parseBoolean(campos[4]));

                    empresa.getTitulos().add(titulo);

                    break;

                case "S":

                    Stakeholder stakeholder = new Stakeholder();

                    stakeholder.setTipoPessoa(TipoPessoa.valueOf(campos[1]));
                    stakeholder.setCadastroPessoa(campos[2]);
                    stakeholder.setNome(campos[3]);

                    titulo.setStakeholder(stakeholder);

                default:
                    break;
            }

            linha = leitura.readLine();
        }

        for(Empresa e: empresaService.obterLista()) {
            System.out.println("Empresa cadastrada com sucesso: " + e);
        }

        leitura.close();
    }
}