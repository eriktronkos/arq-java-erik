package br.edu.infnet.erik.model.service;

import br.edu.infnet.erik.model.domain.Empresa;
import br.edu.infnet.erik.model.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;
    private Map<String, Empresa> mapaEmpresas = new HashMap<String, Empresa>();

    public Empresa incluir(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public Collection<Empresa> obterLista(){
        return mapaEmpresas.values();
    }

}
