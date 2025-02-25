package br.com.fuctura.configuration;

import org.flywaydb.core.Flyway;

public class FlywayConfig {
	public static void main(String[] args) throws ClassNotFoundException {
		
		
		// Configuração do banco de dados
		String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres"; // Altere para o URL do seu banco de dados
		String user = "postgres"; // Altere para seu usuário
		String password = "123456"; // Altere para sua senha

		// Inicializa o Flyway com a configuração do banco de dados
		Flyway flyway = Flyway.configure()
				.dataSource(jdbcUrl, user, password)
				.baselineOnMigrate(true)
				.load();
		
		// Realiza a migração do banco de dados
		flyway.migrate();

		System.out.println("Migração do banco de dados realizada com sucesso.");
	}
}
