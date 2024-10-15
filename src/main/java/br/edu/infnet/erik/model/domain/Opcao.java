package br.edu.infnet.erik.model.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Opcao extends Titulo {
    private BigDecimal custoExercicio;
    private Date dataVesting;

    private boolean exercicioAntecipado;

    public BigDecimal getCustoExercicio() {
        return custoExercicio;
    }

    public void setCustoExercicio(BigDecimal custoExercicio) {
        this.custoExercicio = custoExercicio;
    }

    public Date getDataVesting() {
        return dataVesting;
    }

    public void setDataVesting(Date dataVesting) {
        this.dataVesting = dataVesting;
    }

    public boolean isExercicioAntecipado() {
        return exercicioAntecipado;
    }

    public void setExercicioAntecipado(boolean exercicioAntecipado) {
        this.exercicioAntecipado = exercicioAntecipado;
    }

}
