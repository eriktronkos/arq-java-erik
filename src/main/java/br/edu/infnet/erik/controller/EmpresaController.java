package br.edu.infnet.erik.controller;

import br.edu.infnet.erik.model.domain.Empresa;
import br.edu.infnet.erik.model.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping(value = "/empresa")
    public Collection<Empresa> obterLista(){
        return empresaService.obterLista();
    }

    @PostMapping(value = "/empresa")
    public String incluir(@RequestBody Empresa empresa) {

        empresaService.incluir(empresa);

        return "Inclusão realizada com sucesso";
    }

    @DeleteMapping(value = "/empresa/{id}")
    public String excluir(@PathVariable Integer id) {

        empresaService.excluir(id);

        return "Exclusão realizada com sucesso.";
    }
}
