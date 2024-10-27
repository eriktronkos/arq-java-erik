package br.edu.infnet.erik.model.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TStakeholder")
public class Stakeholder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "stakeholder_id")
    private List<Titulo> titulos;

    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa;
    private String cadastroPessoa;
    private String nome;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public Stakeholder() {
        titulos = new ArrayList<Titulo>();
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getCadastroPessoa() {
        return cadastroPessoa;
    }

    public void setCadastroPessoa(String cadastroPessoa) {
        this.cadastroPessoa = cadastroPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Titulo> getTitulos() {
        return titulos;
    }

    public void setTitulos(List<Titulo> titulos) {
        this.titulos = titulos;
    }
}
