package br.com.controledepontos.model;

import java.util.Date;

public class Ponto {
    private Integer codigo;
    private Date dataHora;
    private Situacao situacao;
    private Funcionario funcionario;

    public Ponto(Integer codigo, Date dataHora, Situacao situacao, Funcionario funcionario) {
        this.codigo = codigo;
        this.dataHora = dataHora;
        this.situacao = situacao;
        this.funcionario = funcionario;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setData(Date dataHora) {
        this.dataHora = dataHora;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
