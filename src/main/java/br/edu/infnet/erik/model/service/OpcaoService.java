package br.edu.infnet.erik.model.service;

import br.edu.infnet.erik.Constants;
import br.edu.infnet.erik.exceptions.NaoEncontradoException;
import br.edu.infnet.erik.model.domain.Acao;
import br.edu.infnet.erik.model.domain.Opcao;
import br.edu.infnet.erik.model.repository.OpcaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpcaoService {

	@Autowired
	private OpcaoRepository opcaoRepository;
	
	public Opcao incluir(Opcao opcao) {
		return opcaoRepository.save(opcao);
	}

	public List<Opcao> obterLista(){
		return (List<Opcao>) opcaoRepository.findAll();
	}

	public Opcao obterPorId(Long id){
		return opcaoRepository.findById(id).orElseThrow(() -> new NaoEncontradoException(Constants.MSG_OPCAO_NOT_FOUND));
	}

	public long obterQuatidade() {
		return opcaoRepository.count();
	}

	public Opcao alterar(Opcao opcao) {

		Opcao opcaoExistente = this.obterPorId(opcao.getId());
		opcao.setEmpresa(opcaoExistente.getEmpresa());
		opcao.setStakeholder(opcaoExistente.getStakeholder());
		return opcaoRepository.save(opcao);
	}

	public boolean excluir(Long id) {

		opcaoRepository.deleteById(id);

		return true;
	}
}
