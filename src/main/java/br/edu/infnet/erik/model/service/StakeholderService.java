package br.edu.infnet.erik.model.service;

import br.edu.infnet.erik.Constants;
import br.edu.infnet.erik.exceptions.NaoEncontradoException;
import br.edu.infnet.erik.model.domain.Empresa;
import br.edu.infnet.erik.model.domain.Endereco;
import br.edu.infnet.erik.model.domain.Stakeholder;
import br.edu.infnet.erik.model.repository.StakeholderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StakeholderService {

	@Autowired
	private LocalizacaoService localizacaoService;

	@Autowired
	private StakeholderRepository stakeholderRepository;
	
	public Stakeholder incluir(Stakeholder stakeholder) {
		String cep = stakeholder.getEndereco().getCep();

		Endereco endereco = localizacaoService.findByCep(cep);

		stakeholder.setEndereco(endereco);
		return stakeholderRepository.save(stakeholder);
	}

	public List<Stakeholder> obterLista(){
		return (List<Stakeholder>) stakeholderRepository.findAll();
	}

	public Stakeholder obterPorId(Long id){
		return stakeholderRepository.findById(id).orElseThrow(() -> new NaoEncontradoException(Constants.MSG_STAKEHOLDER_NOT_FOUND));
	}

	public Stakeholder obterPorCadastroPessoal(String cadastroPessoa){
		return stakeholderRepository.findByCadastroPessoa(cadastroPessoa);
	}

	public Stakeholder alterar(Stakeholder stakeholder) {

		String cep = stakeholder.getEndereco().getCep();

		Endereco endereco = localizacaoService.findByCep(cep);

		Stakeholder stakeholderExistente = stakeholderRepository.findById(stakeholder.getId()).orElseThrow(() -> new NaoEncontradoException(Constants.MSG_STAKEHOLDER_NOT_FOUND));

		endereco.setId(stakeholderExistente.getEndereco().getId());
		stakeholder.setEndereco(endereco);
		stakeholder.setTitulos(stakeholderExistente.getTitulos());
		return stakeholderRepository.save(stakeholder);
	}

	public void excluir(Long id) {
		stakeholderRepository.deleteById(id);
	}

	public long obterQuatidade() {
		return stakeholderRepository.count();
	}
}
