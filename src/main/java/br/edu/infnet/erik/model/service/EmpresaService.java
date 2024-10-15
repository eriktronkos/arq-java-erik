package br.edu.infnet.erik.model.service;

import br.edu.infnet.erik.model.domain.Empresa;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmpresaService {

    private Map<String, Empresa> mapaEmpresas = new HashMap<String, Empresa>();

    public void incluir(Empresa empresa) {
        mapaEmpresas.put(empresa.getCnpj(), empresa);
    }

    public Collection<Empresa> obterLista(){
        return mapaEmpresas.values();
    }

}
