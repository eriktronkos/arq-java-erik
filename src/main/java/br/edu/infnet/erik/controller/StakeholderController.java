package br.edu.infnet.erik.controller;

import br.edu.infnet.erik.model.domain.Stakeholder;
import br.edu.infnet.erik.model.service.StakeholderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class StakeholderController {

    @Autowired
    private StakeholderService stakeholderService;

    @GetMapping(value = "/stakeholder")
    public Collection<Stakeholder> obterLista(){
        return stakeholderService.obterLista();
    }

    @PostMapping(value = "/stakeholder")
    public String incluir(@RequestBody Stakeholder stakeholder) {

        stakeholderService.incluir(stakeholder);

        return "Inclusão realizada com sucesso";
    }

    @DeleteMapping(value = "/stakeholder/{id}")
    public String excluir(@PathVariable Integer id) {

        stakeholderService.excluir(id);

        return "Exclusão realizada com sucesso.";
    }
}
