package br.com.controledepontos.model;

public class Cargo {
    private Integer codigo;
    private String nome;
    private Turno turno;

    public Cargo(Integer codigo, String nome, Turno turno) {
        this.codigo = codigo;
        this.nome = nome;
        this.turno = turno;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }
}
