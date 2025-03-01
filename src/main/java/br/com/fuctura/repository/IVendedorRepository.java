package br.com.fuctura.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import br.com.fuctura.entity.Vendedor;

public interface IVendedorRepository {

    Vendedor save(Connection connection, Vendedor vendedor) throws SQLException;
    Optional<List<Vendedor>> findAll(Connection connection) throws SQLException;
    Optional<Vendedor> findById(Connection connection, Integer codigo) throws SQLException;
    Optional<Vendedor> findByNome(Connection connection, String nome) throws SQLException;
    Vendedor update(Connection connection, Vendedor vendedor) throws SQLException;
    Vendedor delete(Connection connection, Vendedor vendedor) throws SQLException;

}
