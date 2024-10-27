package br.edu.infnet.erik.model.repository;

import br.edu.infnet.erik.model.domain.Stakeholder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StakeholderRepository extends CrudRepository<Stakeholder, Integer> {

}
