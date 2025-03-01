package br.com.fuctura.entity;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name  = "venda")
public class Venda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @OneToOne
    @JoinColumn(name = "codigo_veiculo")
    private Veiculo codVeiculo;

    @OneToOne
    @JoinColumn(name = "codigo_vendedor")
    private Vendedor codVendedor;
    
    @OneToOne
    @JoinColumn(name = "codigo_cliente")
    private Cliente codCliente;

    @ManyToOne
    @JoinColumn(name = "codigo_loja")
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


    @Override
    public String toString() {
        return "Venda [codigo=" + codigo + ", codVeiculo=" + codVeiculo + ", codVendedor=" + codVendedor + ", codCliente="
                + codCliente + ", codLoja=" + codLoja + ", valor=" + valor + ", dhVenda=" + dhVenda + "]";
    }
}
