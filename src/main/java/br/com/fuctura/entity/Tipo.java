package br.com.fuctura.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo")
public class Tipo {

	private Integer codigo;
	private String nome;
	
	public Tipo() {
		super();
	}

	public Tipo(String nome) {
		super();
		this.nome = nome;
	}

	public Tipo(Integer codigo, String nome) {
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
