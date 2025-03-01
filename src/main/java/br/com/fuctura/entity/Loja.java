package br.com.fuctura.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "loja")
public class Loja {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	private String nome;

	@OneToOne(cascade  = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "endereco_loja",
	joinColumns = @JoinColumn(name = "codigo_endereco"),
			inverseJoinColumns = @JoinColumn(name = "codigo_loja")
			)
	private Endereco endereco;

	@OneToMany
	@JoinTable(name = "loja_veiculo",
			joinColumns = @JoinColumn(name = "codigo_loja"),
			inverseJoinColumns = @JoinColumn(name = "codigo_veiculo")
			)
	private List<Veiculo> veiculos;

	@OneToMany(mappedBy = "codLoja")
	private List<Venda> vendas = new ArrayList<>();
	
	public Loja() {
		this.veiculos = new ArrayList<Veiculo>();
	}

	public Loja(String nome, Endereco endereco) {
		super();
		this.nome = nome;
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

	public List<Venda> getVendas() {
		return vendas;
	}

	public void add(Venda venda) {
		this.vendas.add(venda);
	}

	@Override
	public String toString() {
		return "Loja [codigo=" + codigo + ", nome=" + nome + "]";
	}

}
