package br.edu.infnet.erik.controller;

import br.edu.infnet.erik.Constants;
import br.edu.infnet.erik.model.domain.Acao;
import br.edu.infnet.erik.model.domain.Opcao;
import br.edu.infnet.erik.model.service.OpcaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/opcoes")
public class OpcaoController {

	@Autowired
	private OpcaoService opcaoService;

	@GetMapping(value = "")
	public List<Opcao> obterLista(){
		return opcaoService.obterLista();
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Opcao> obterPorId(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(opcaoService.obterPorId(id));
	}

	@PostMapping(value = "")
	public ResponseEntity<String> incluir(@RequestBody Opcao opcao) {

		opcaoService.incluir(opcao);

		return ResponseEntity.status(HttpStatus.CREATED).body(Constants.MSG_INCLUSAO_SUCESSO);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Opcao> alterar(@RequestBody Opcao opcao, @PathVariable Long id) {

		opcao.setId(id);
		Opcao opcaoAtualizada = opcaoService.alterar(opcao);

		return ResponseEntity.ok(opcaoAtualizada);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> excluir(@PathVariable Long id) {


		if (opcaoService.excluir(id)) {
			return ResponseEntity.ok(Constants.MSG_EXCLUSAO_SUCESSO);
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Constants.MSG_ACAO_NOT_FOUND);
	}
}