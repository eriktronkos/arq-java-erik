package br.edu.infnet.erik.model.repository;

import br.edu.infnet.erik.model.domain.Titulo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TituloRepository extends CrudRepository<Titulo, Integer> {

}
