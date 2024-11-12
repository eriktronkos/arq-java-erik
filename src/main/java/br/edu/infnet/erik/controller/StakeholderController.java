package br.edu.infnet.erik.controller;

import br.edu.infnet.erik.model.domain.Stakeholder;
import br.edu.infnet.erik.model.service.StakeholderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/stakeholders")
public class StakeholderController {

    @Autowired
    private StakeholderService stakeholderService;

    @GetMapping(value = "")
    public ResponseEntity<Collection<Stakeholder>> obterLista(){
        return ResponseEntity.status(HttpStatus.OK).body(stakeholderService.obterLista());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Stakeholder> obterPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(stakeholderService.obterPorId(id));
    }

    @PostMapping(value = "")
    public String incluir(@RequestBody Stakeholder stakeholder) {

        stakeholderService.incluir(stakeholder);

        return "Inclusão realizada com sucesso";
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Stakeholder> alterar(@RequestBody Stakeholder stakeholder, @PathVariable Long id) {

        stakeholder.setId(id);
        Stakeholder stakeholderAtualizado = stakeholderService.alterar(stakeholder);

        return ResponseEntity.ok(stakeholderAtualizado);
    }

    @DeleteMapping(value = "/{id}")
    public String excluir(@PathVariable Long id) {

        stakeholderService.excluir(id);

        return "Exclusão realizada com sucesso.";
    }
}
