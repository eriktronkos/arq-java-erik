package br.edu.infnet.erik.model.service;

import br.edu.infnet.erik.Constants;
import br.edu.infnet.erik.exceptions.NaoEncontradoException;
import br.edu.infnet.erik.model.domain.Empresa;
import br.edu.infnet.erik.model.domain.Endereco;
import br.edu.infnet.erik.model.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private LocalizacaoService localizacaoService;
    public Empresa incluir(Empresa empresa) {

        String cep = empresa.getEndereco().getCep();

        Endereco endereco = localizacaoService.findByCep(cep);

        empresa.setEndereco(endereco);
        return empresaRepository.save(empresa);
    }

    public Empresa alterar(Empresa empresa) {

        String cep = empresa.getEndereco().getCep();

        Endereco endereco = localizacaoService.findByCep(cep);

        Empresa empresaExistente = empresaRepository.findById(empresa.getId()).orElseThrow(() -> new NaoEncontradoException(Constants.MSG_EMPRESA_NOT_FOUND));

        endereco.setId(empresaExistente.getEndereco().getId());
        empresa.setEndereco(endereco);
        empresa.setTitulos(empresaExistente.getTitulos());
        return empresaRepository.save(empresa);
    }

    public boolean excluir(Long id) {
        empresaRepository.deleteById(id);

        return true;
    }

    public Collection<Empresa> obterLista(){
        return (Collection<Empresa>) empresaRepository.findAll();
    }

    public List<Empresa> obterPorNome(String nome){
        return empresaRepository.findByNomeContaining(nome);
    }

    public long obterQuantidade() {
        return empresaRepository.count();
    }

    public Empresa obterPorId(Long id) {
        return empresaRepository.findById(id).orElseThrow(() -> new NaoEncontradoException(Constants.MSG_EMPRESA_NOT_FOUND));
    }

    public Empresa obterPorCpnj(String cnpj) { return empresaRepository.findByCnpj(cnpj).orElse(null) ;}
}
