package br.edu.infnet.erik.model.domain;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

@Entity
@Table(name = "TTitulo")
@Inheritance(strategy = InheritanceType.JOINED)
public class Titulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "stakeholder_id")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private Stakeholder stakeholder;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Stakeholder getStakeholder() {
        return stakeholder;
    }

    public void setStakeholder(Stakeholder stakeholder) {
        this.stakeholder = stakeholder;
    }

}

