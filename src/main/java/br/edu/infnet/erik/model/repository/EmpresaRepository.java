package br.edu.infnet.erik.model.repository;

import br.edu.infnet.erik.model.domain.Empresa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, Long> {

    List<Empresa> findByNomeContaining(String nome);

    Optional<Empresa> findByCnpj(String cnpj);
}
