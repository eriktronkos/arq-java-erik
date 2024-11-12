package br.edu.infnet.erik.model.repository;

import br.edu.infnet.erik.model.domain.Acao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcaoRepository extends CrudRepository<Acao, Long> {

}
