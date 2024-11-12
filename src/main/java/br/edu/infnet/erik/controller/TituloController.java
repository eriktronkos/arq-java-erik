package br.edu.infnet.erik.controller;

import br.edu.infnet.erik.model.domain.Titulo;
import br.edu.infnet.erik.model.service.TituloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/titulos")
public class TituloController {

	@Autowired
	private TituloService tituloService;
		
	@GetMapping(value = "")
	public ResponseEntity<List<Titulo>> obterLista(@RequestParam(required = false) Long empresa_id, @RequestParam(required = false) Long stakeholder_id){
		return ResponseEntity.ok(tituloService.obterLista(empresa_id, stakeholder_id));
	}	
}