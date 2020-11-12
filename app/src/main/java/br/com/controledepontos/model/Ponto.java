package br.com.controledepontos.model;

import java.sql.Date;
import java.sql.Time;

public class Ponto {
    private Integer codigo;
    private Date data;
    private Time horario;
    private Situacao situacao;

    public Ponto(Integer codigo, Date data, Time horario, Situacao situacao) {
        this.codigo = codigo;
        this.data = data;
        this.horario = horario;
        this.situacao = situacao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHorario() {
        return horario;
    }

    public void setHorario(Time horario) {
        this.horario = horario;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }
}
