package br.com.fuctura.entity;

import br.com.fuctura.listeners.EnderecoListener;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "endereco")
@EntityListeners(EnderecoListener.class)
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Override
    public String toString() {
        return "Endereco [codigo=" + codigo + ", cep=" + cep + ", logradouro=" + logradouro + ", complemento="
                + complemento + ", numero=" + numero + "]";
    }
}
