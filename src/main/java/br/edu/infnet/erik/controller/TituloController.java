package br.edu.infnet.erik.controller;

import br.edu.infnet.erik.model.domain.Titulo;
import br.edu.infnet.erik.model.service.TituloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TituloController {

	@Autowired
	private TituloService tituloService;
		
	@GetMapping(value = "/titulo")
	public List<Titulo> obterLista(){
		return tituloService.obterLista();
	}	
}