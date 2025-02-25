package br.com.fuctura.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "endereco")
public class Endereco {
   
    private Integer codigo;
	private String cep;
	private String logradouro;
	private String complemento;
	private Integer numero;

    public Endereco() {
    }

    public Endereco(String cep, String logradouro, String complemento, Integer numero) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.numero = numero;
    }

    public Integer getCodigo() {
        return codigo;
    }   

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
}
