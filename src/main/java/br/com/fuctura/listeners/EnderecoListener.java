package br.com.fuctura.listeners;

import br.com.fuctura.entity.Endereco;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;

public class EnderecoListener {
	
	@PrePersist
	public void beforePersist(Endereco endereco) {
		System.out.println("Endereço que será salvo: " + endereco);
	}
	
	@PostPersist
	public void postPersist(Endereco endereco) {
		System.out.println("Endereço que será salvo: " + endereco);
	}

	@PreUpdate
    private void antesDeAtualizar(Endereco endereco) {
        System.out.println("Endereço será atualizado: " + endereco);
    }

    @PostUpdate
    private void depoisDeAtualizar(Endereco endereco) {
        System.out.println("Endereço atualizado: " + endereco);
    }

    @PreRemove
    private void antesDeRemover(Endereco endereco) {
        System.out.println("Endereço será removido: " + endereco);
    }

    @PostRemove
    private void depoisDeRemover(Endereco endereco) {
        System.out.println("Endereço removido do banco: " + endereco);
    }

    @PostLoad
    private void depoisDeCarregar(Endereco endereco) {
        System.out.println("Endereço carregado do banco: " + endereco);
    }

}
