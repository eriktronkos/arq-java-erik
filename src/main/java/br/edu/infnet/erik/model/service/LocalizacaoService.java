package br.edu.infnet.erik.model.service;

import br.edu.infnet.erik.client.EnderecoClient;
import br.edu.infnet.erik.client.LocalidadeClient;
import br.edu.infnet.erik.model.domain.Endereco;
import br.edu.infnet.erik.model.domain.Estado;
import br.edu.infnet.erik.model.domain.Municipio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class LocalizacaoService {

	@Autowired
	private EnderecoClient enderecoClient;
	@Autowired
	private LocalidadeClient localidadeClient;

	public Endereco findByCep(String cep) {
		return enderecoClient.findByCep(cep);
	}

	public Collection<Estado> obterEstados(){
		return localidadeClient.obterEstados();
	}
	
	public Collection<Municipio> obterMunicipios(Integer uf){
		return localidadeClient.obterMunicipios(uf);
	}
}
