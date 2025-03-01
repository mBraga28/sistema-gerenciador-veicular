package br.com.fuctura;

import java.time.Instant;
import java.util.Scanner;

import br.com.fuctura.entity.Cliente;
import br.com.fuctura.entity.Loja;
import br.com.fuctura.entity.Tipo;
import br.com.fuctura.entity.Veiculo;
import br.com.fuctura.entity.Venda;
import br.com.fuctura.entity.Vendedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("FUCTURA-PU");
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction();
		
		// var endereco = new Endereco();
		// endereco.setLogradouro("Av. Rui Barbosa");
		// endereco.setCep("52050000");
		// endereco.setComplemento("");
		// endereco.setNumero(1105);
		
		// em.getTransaction().begin();
		// em.persist(endereco);
		// em.getTransaction().commit();
		
		// var loja = new Loja();
		// loja.setNome("Toyolex");
		
		// var veiculo = new Veiculo();
		// veiculo.setPlaca("ktt2297");
		
		// var veiculo2 = new Veiculo();
		// veiculo2.setPlaca("juy1109");
		// veiculo2.setModelo("Corolla");
		// veiculo2.setAno(2021);
		// veiculo2.setValor(112000.0);
		// veiculo2.getTipo().setCodigo(3);
		// veiculo2.getLoja().setCodigo(6);
		
		// em.getTransaction().begin();
		// em.persist(veiculo2);
		// em.getTransaction().commit();
		
		Scanner scanner = new Scanner(System.in);
		
		 System.out.println("Excluindo veículo...");
         // Lógica para excluir veículo
         System.out.println("Digite o código do veículo: ");
         String codigo = scanner.nextLine();
         Veiculo veiculoExcluir = em.find(Veiculo.class, Integer.parseInt(codigo));
         
         em.getTransaction().begin();
         em.remove(veiculoExcluir);
         em.getTransaction().commit();
         System.out.println("Veículo excluido com sucesso!");
         
		scanner.close();			

	}

}
