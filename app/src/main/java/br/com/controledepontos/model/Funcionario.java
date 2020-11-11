package br.com.controledepontos.model;

public class Funcionario {
    private Integer codigo;
    private String usuario;
    private String senha;
    private String email;
    private String nome;
    private Cargo cargo;

    public Funcionario(Integer codigo, String usuario, String senha, String email, String nome, Cargo cargo) {
        this.codigo = codigo;
        this.usuario = usuario;
        this.senha = senha;
        this.email = email;
        this.nome = nome;
        this.cargo = cargo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}
