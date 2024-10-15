package br.edu.infnet.erik.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String cnpj;
    private String nome;
    private List<Titulo> titulos;

    public Empresa() {
        titulos = new ArrayList<Titulo>();
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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
