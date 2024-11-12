package br.edu.infnet.erik.model.repository;

import br.edu.infnet.erik.model.domain.Opcao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpcaoRepository extends CrudRepository<Opcao, Long> {

}
