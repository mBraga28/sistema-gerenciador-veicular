package br.com.fuctura.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "loja")
public class Loja {
	
	private Integer codigo;
	private String nome;

	@OneToOne
	private Endereco endereco;

	@OneToMany
	private List<Veiculo> veiculos;
	
	public Loja() {
		this.veiculos = new ArrayList<Veiculo>();
	}

	public Loja(String nome, Endereco endereco) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.veiculos = new ArrayList<Veiculo>();
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void add(Veiculo veiculo) {
		this.veiculos.add(veiculo);
	}

}
