package br.edu.infnet.erik.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Stakeholder {

    private List<Titulo> titulos;
    private TipoPessoa tipoPessoa;
    private String cadastroPessoa;
    private String nome;

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
