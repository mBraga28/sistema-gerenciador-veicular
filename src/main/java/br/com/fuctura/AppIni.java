package br.com.fuctura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

import br.com.fuctura.entity.Tipo;
import br.com.fuctura.entity.Veiculo;
import br.com.fuctura.repository.impl.VeiculoRepository;

public class AppIni {

	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5432/postgres?loglevel=2";
		String user = "postgres";
		String pass = "123456";
		
		
		try {
			Connection connection = DriverManager.getConnection(url, user, pass);
			
			System.out.println("Conectado com sucesso!");

			String placa = "ppr2277";
			String modelo = "Argo";
			int ano = 2023;
			double valor = 80000.0;
			Tipo tipo = new Tipo();
			tipo.setCodigo(5);
			
			Veiculo v = new Veiculo(placa, modelo, ano, valor, tipo);
			
			VeiculoRepository repository = new VeiculoRepository();
			
			repository.save(connection, v);
			
			if(Objects.nonNull(v.getCodigo())) {
				System.out.println("Veiculo registrado com sucesso!");
				System.out.println("Codigo: " + v.getCodigo());
			}
			
		} catch (SQLException e) {
			System.out.println("Erro de conexão, motivo: ");
			e.printStackTrace();
		}
	}
}
