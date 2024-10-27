package br.edu.infnet.erik.model.repository;

import br.edu.infnet.erik.model.domain.Empresa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, Integer> {

}
