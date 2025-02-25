package br.com.fuctura.entity;

public class Vendedor {

    private Integer codigo;
    private String nome;

    public Vendedor() {
        super();
    }

    public Vendedor(Integer codigo, String nome) {
        super();
        this.codigo = codigo;
        this.nome = nome;
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

}
