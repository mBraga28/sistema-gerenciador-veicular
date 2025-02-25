package br.com.fuctura.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import br.com.fuctura.entity.Veiculo;

public interface IVeiculoRepository {

    // Optional<Veiculo> findById(Connection connection, Integer codigo)  throws SQLException;
    Veiculo save(Connection connection, Veiculo veiculo) throws SQLException;
    Optional<List<Veiculo>> findAll(Connection connection) throws SQLException; //List

}
