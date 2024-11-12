package br.edu.infnet.erik.controller;

import br.edu.infnet.erik.Constants;
import br.edu.infnet.erik.model.domain.Acao;
import br.edu.infnet.erik.model.service.AcaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acoes")
public class AcaoController {

	@Autowired
	private AcaoService acaoService;
		
	@GetMapping(value = "")
	public ResponseEntity<List<Acao>> obterLista(){
		return ResponseEntity.status(HttpStatus.OK).body(acaoService.obterLista());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Acao> obterPorId(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(acaoService.obterPorId(id));
	}

	@PostMapping(value = "")
	public ResponseEntity<String> incluir(@RequestBody Acao acao) {

		acaoService.incluir(acao);

		return ResponseEntity.status(HttpStatus.CREATED).body(Constants.MSG_INCLUSAO_SUCESSO);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Acao> alterar(@RequestBody Acao acao, @PathVariable Long id) {

		acao.setId(id);
		Acao acaoAtualizada = acaoService.alterar(acao);

		return ResponseEntity.ok(acaoAtualizada);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> excluir(@PathVariable String id) {


		if (acaoService.excluir(Long.valueOf(id))) {
			return ResponseEntity.ok(Constants.MSG_EXCLUSAO_SUCESSO);
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Constants.MSG_ACAO_NOT_FOUND);
	}
}