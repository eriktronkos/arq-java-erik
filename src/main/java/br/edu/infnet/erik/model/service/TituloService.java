package br.edu.infnet.erik.model.service;

import br.edu.infnet.erik.model.domain.Titulo;
import br.edu.infnet.erik.model.repository.TituloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Service
public class TituloService {

	@Autowired
	private TituloRepository tituloRepository;
	
	public Titulo incluir(Titulo titulo) {
		return tituloRepository.save(titulo);
	}

	public List<Titulo> obterLista(){
		return this.obterLista(null, null);
	}
	public List<Titulo> obterLista(Long empresaId, Long stakeholderId){

		if (!Objects.isNull(empresaId)) {
			if (!Objects.isNull(stakeholderId)) {
				return  tituloRepository.findByEmpresaIdAndStakeholderId(empresaId, stakeholderId);
			}
			return  tituloRepository.findByEmpresaId(empresaId);
		}
		if (!Objects.isNull(stakeholderId)) {
			return  tituloRepository.findByStakeholderId(stakeholderId);
		}
		return (List<Titulo>) tituloRepository.findAll();
	}

	public long obterQuatidade() {
		return tituloRepository.count();
	}
}
