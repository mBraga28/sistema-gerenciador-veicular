package br.com.fuctura.entity;

import java.time.Instant;

public class Venda {

    private Integer codigo;

    private Veiculo codVeiculo;
    private Vendedor codVendedor;
    private Cliente codCliente;
    private Loja codLoja;

    private Double valor;
    private Instant dhVenda;

    public Venda() {
        super();
    }

    public Venda(Integer codigo, Veiculo codVeiculo, Vendedor codVendedor, Cliente codCliente, Loja codLoja, Double valor, Instant dhVenda) {
        super();
        this.codigo = codigo;
        this.codVeiculo = codVeiculo;
        this.codVendedor = codVendedor;
        this.codCliente = codCliente;
        this.codLoja = codLoja;
        this.valor = valor;
        this.dhVenda = dhVenda;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Veiculo getVeiculo() {
        return codVeiculo;
    }

    public void setVeiculo(Veiculo codVeiculo) {
        this.codVeiculo = codVeiculo;
    }

    public Vendedor getVendedor() {
        return codVendedor;
    }

    public void setVendedor(Vendedor codVendedor) {
        this.codVendedor = codVendedor;
    }

    public Cliente getCliente() {
        return codCliente;
    }

    public void setCliente(Cliente codCliente) {
        this.codCliente = codCliente;
    }

    public Loja getLoja() {
        return codLoja;
    }

    public void setLoja(Loja codLoja) {
        this.codLoja = codLoja;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Instant getDhVenda() {
        return dhVenda;
    }

    public void setDhVenda(Instant dhVenda) {
        this.dhVenda = dhVenda;
    }

}
