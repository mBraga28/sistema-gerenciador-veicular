package br.com.fuctura.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import br.com.fuctura.entity.Cliente;

public interface IClienteRepository {

    Cliente save(Connection connection, Cliente cliente) throws SQLException;
    Optional<List<Cliente>> findAll(Connection connection) throws SQLException;
    Optional<Cliente> findById(Connection connection, Integer codigo) throws SQLException;
    Cliente update(Connection connection, Cliente cliente) throws SQLException;
    Cliente delete(Connection connection, Cliente cliente) throws SQLException;

}
