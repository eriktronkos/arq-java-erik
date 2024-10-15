package br.edu.infnet.erik.controller;

import br.edu.infnet.erik.model.domain.Empresa;
import br.edu.infnet.erik.model.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping(value = "/empresa")
    public Collection<Empresa> obterLista(){
        return empresaService.obterLista();
    }
}
