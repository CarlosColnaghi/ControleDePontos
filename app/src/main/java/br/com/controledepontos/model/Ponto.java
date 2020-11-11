package br.com.controledepontos.model;

import java.sql.Date;
import java.sql.Time;

public class Ponto {
    private Integer ponto;
    private Date data;
    private Time horiario;
    private Situacao situacao;

    public Ponto(Integer ponto, Date data, Time horiario, Situacao situacao) {
        this.ponto = ponto;
        this.data = data;
        this.horiario = horiario;
        this.situacao = situacao;
    }

    public Integer getPonto() {
        return ponto;
    }

    public void setPonto(Integer ponto) {
        this.ponto = ponto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHoriario() {
        return horiario;
    }

    public void setHoriario(Time horiario) {
        this.horiario = horiario;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }
}
