package br.edu.infnet.erik.model.service;

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

    public void excluir(Integer id) {
        empresaRepository.deleteById(id);
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

    public Empresa obterPorId(Integer id) {
        return empresaRepository.findById(id).orElse(null);
    }

    public Empresa obterPorCpnj(String cnpj) { return empresaRepository.findByCnpj(cnpj).orElse(null) ;}
}
