package br.edu.infnet.erik.model.service;

import br.edu.infnet.erik.exceptions.NaoEncontradoException;
import br.edu.infnet.erik.model.domain.Acao;
import br.edu.infnet.erik.model.domain.Empresa;
import br.edu.infnet.erik.model.domain.Stakeholder;
import br.edu.infnet.erik.model.repository.AcaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.infnet.erik.Constants;

import java.util.List;

@Service
public class AcaoService {

	@Autowired
	private AcaoRepository acaoRepository;

	@Autowired
	private EmpresaService empresaService;

	@Autowired
	private StakeholderService stakeholderService;
	public Acao incluir(Acao acao) {
		Empresa empresa = empresaService.obterPorId(acao.getEmpresa().getId());
		Stakeholder stakeholder = stakeholderService.obterPorId(acao.getStakeholder().getId());
		acao.setEmpresa(empresa);
		acao.setStakeholder(stakeholder);
		return acaoRepository.save(acao);
	}

	public List<Acao> obterLista(){
		return (List<Acao>) acaoRepository.findAll();
	}

	public Acao obterPorId(Long id){
		return acaoRepository.findById(id).orElseThrow(() -> new NaoEncontradoException(Constants.MSG_ACAO_NOT_FOUND));
	}

	public long obterQuantidade() {
		return acaoRepository.count();
	}

	public Acao alterar(Acao acao) {

		Acao acaoExistente = this.obterPorId(acao.getId());
		acao.setEmpresa(acaoExistente.getEmpresa());
		acao.setStakeholder(acaoExistente.getStakeholder());
		return acaoRepository.save(acao);
	}

	public boolean excluir(Long id) {

		acaoRepository.deleteById(id);

		return true;
	}
}
