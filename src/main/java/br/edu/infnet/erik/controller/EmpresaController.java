package br.edu.infnet.erik.controller;

import br.edu.infnet.erik.Constants;
import br.edu.infnet.erik.model.domain.Empresa;
import br.edu.infnet.erik.model.domain.Opcao;
import br.edu.infnet.erik.model.service.EmpresaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping(value = "")
    public ResponseEntity<Collection<Empresa>> obterLista(){
        return ResponseEntity.status(HttpStatus.OK).body(empresaService.obterLista());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Empresa> obterPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(empresaService.obterPorId(id));
    }

    @PostMapping(value = "", consumes = {"application/json"})
    public ResponseEntity<String> incluir(@RequestBody Empresa empresa) {

        empresaService.incluir(empresa);

        return ResponseEntity.ok(Constants.MSG_INCLUSAO_SUCESSO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Empresa> alterar(@RequestBody Empresa empresa, @PathVariable Long id) {

        empresa.setId(id);
        Empresa empresaAtualizada = empresaService.alterar(empresa);

        return ResponseEntity.ok(empresaAtualizada);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {

        if (empresaService.excluir(id)) {
            return ResponseEntity.ok(Constants.MSG_EXCLUSAO_SUCESSO);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Constants.MSG_EMPRESA_NOT_FOUND);
    }
}
