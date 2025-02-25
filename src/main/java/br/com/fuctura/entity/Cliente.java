package br.com.fuctura.entity;

public class Cliente {

    private Integer codigo;
    private String nome;
    private String cpf;
    private String celular;

    private Endereco endereco;

    public Cliente() {
        super();
    }

    public Cliente(String nome, String cpf, String celular, Endereco endereco) {
        super();
        this.nome = nome;
        this.cpf = cpf;
        this.celular = celular;
        this.endereco = endereco;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
