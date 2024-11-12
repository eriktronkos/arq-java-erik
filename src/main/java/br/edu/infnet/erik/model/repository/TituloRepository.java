package br.edu.infnet.erik.model.repository;

import br.edu.infnet.erik.model.domain.Empresa;
import br.edu.infnet.erik.model.domain.Titulo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TituloRepository extends CrudRepository<Titulo, Integer> {
    List<Titulo> findByEmpresaId(Long empresaId);
    List<Titulo> findByStakeholderId(Long empresaId);
    List<Titulo> findByEmpresaIdAndStakeholderId(Long empresaId, Long stakeholderId);
}
