package br.com.fuctura.repository.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import br.com.fuctura.dao.VeiculoDAO;
import br.com.fuctura.entity.Veiculo;
import br.com.fuctura.repository.IVeiculoRepository;

public class VeiculoRepository implements IVeiculoRepository {
	

	private final VeiculoDAO veiculoDAO;

	public VeiculoRepository() {
		this.veiculoDAO = new VeiculoDAO();
	}

	@Override
	public Veiculo save(Connection connection, Veiculo veiculo) throws SQLException {
		return veiculoDAO.save(connection, veiculo);
	}

	@Override
	public Optional<List<Veiculo>> findAll(Connection connection) throws SQLException {
		return veiculoDAO.findAll(connection);
	}
}
