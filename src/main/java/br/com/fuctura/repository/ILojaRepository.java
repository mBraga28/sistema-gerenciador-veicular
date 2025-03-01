package br.com.fuctura.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import br.com.fuctura.entity.Loja;

public interface ILojaRepository {

    Optional<Loja> findById(Connection connection, Integer codigo) throws SQLException;
    Optional<Loja> findByNome(Connection connection, String nome) throws SQLException;
    Optional<List<Loja>> findAll(Connection connection) throws SQLException;
    Loja save(Connection connection, Loja loja) throws SQLException;
    Loja update(Connection connection, Loja loja) throws SQLException;
    Loja delete(Connection connection, Loja loja) throws SQLException;
}
