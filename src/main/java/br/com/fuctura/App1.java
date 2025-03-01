package br.com.fuctura;

import java.util.Scanner;

import br.com.fuctura.entity.Veiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App1 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("FUCTURA-PU");
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction();
		
		Scanner scanner = new Scanner(System.in);
		
		 System.out.println("Consultando Veículo por Placa...");
         System.out.print("Digite a placa do veículo: ");
         String consultarPlaca = scanner.nextLine();
         Veiculo veiculo = em.createQuery("SELECT v FROM Veiculo v WHERE v.placa = :placa", Veiculo.class)
           .setParameter("placa", consultarPlaca)
           .getResultList()
           .stream()
           .findFirst()
           .orElse(null);
         if (veiculo != null) {
             System.out.println("Veículo encontrado: " + veiculo);
         } else {
             System.out.println("Veículo não encontrado.");
         }
        
        scanner.close();
		
		em.getTransaction().begin();
		em.persist(veiculo);
		em.getTransaction().commit();

	}

}
