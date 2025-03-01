package br.com.fuctura.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "veiculo")
public class Veiculo {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	private String placa;
	private String modelo; 
	private int ano;
	private double valor;

	// relação de 1 para muitos com a tabela tipo
	@ManyToOne
	@JoinTable( name = "veiculo_tipo", 
			joinColumns = @JoinColumn(name = "codigo_veiculo"),
			inverseJoinColumns = @JoinColumn(name = "codigo_tipo"))
	private Tipo tipo; 

	@ManyToOne
	private Loja loja;
	
	
	public Veiculo(String placa, String modelo, int ano, double valor, Tipo tipo) {
		super();
		this.placa = placa;
		this.modelo = modelo;
		this.ano = ano;
		this.valor = valor;
		this.tipo = tipo;
	}

	public Veiculo(String placa, String modelo, int ano, double valor, Tipo tipo, Loja loja) {
		super();
		this.placa = placa;
		this.modelo = modelo;
		this.ano = ano;
		this.valor = valor;
		this.tipo = tipo;
		this.loja = loja;
	}
	
	public Veiculo() {}
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	@Override
	public String toString() {
		return "Veiculo [codigo=" + codigo + ", placa=" + placa + ", modelo=" + modelo + ", ano=" + ano + ", valor="
				+ valor + ", tipo=" + tipo + ", loja=" + loja  + "]";
	}
	
	
}
