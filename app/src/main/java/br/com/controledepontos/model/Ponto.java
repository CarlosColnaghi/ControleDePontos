package br.com.controledepontos.model;

import java.sql.Date;
import java.sql.Time;

public class Ponto {
    private Integer ponto;
    private Date data;
    private Time horario;
    private Situacao situacao;

    public Ponto(Integer ponto, Date data, Time horario, Situacao situacao) {
        this.ponto = ponto;
        this.data = data;
        this.horario = horario;
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

    public Time gethorario() {
        return horario;
    }

    public void sethorario(Time horario) {
        this.horario = horario;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }
}
