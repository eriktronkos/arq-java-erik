package br.edu.infnet.erik.model.service;

import br.edu.infnet.erik.model.domain.Titulo;
import br.edu.infnet.erik.model.repository.TituloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TituloService {

	@Autowired
	private TituloRepository tituloRepository;
	
	public Titulo incluir(Titulo titulo) {
		return tituloRepository.save(titulo);
	}
}
