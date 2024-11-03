package br.edu.infnet.erik.model.service;

import br.edu.infnet.erik.model.domain.Stakeholder;
import br.edu.infnet.erik.model.repository.StakeholderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StakeholderService {

	@Autowired
	private StakeholderRepository stakeholderRepository;
	
	public Stakeholder incluir(Stakeholder stakeholder) {
		return stakeholderRepository.save(stakeholder);
	}

	public List<Stakeholder> obterLista(){
		return (List<Stakeholder>) stakeholderRepository.findAll();
	}

	public Stakeholder obterPorCadastroPessoal(String cadastroPessoa){
		return stakeholderRepository.findByCadastroPessoa(cadastroPessoa);
	}

	public void excluir(Integer id) {
		stakeholderRepository.deleteById(id);
	}

	public long obterQuatidade() {
		return stakeholderRepository.count();
	}
}
