package br.com.fuctura.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

import br.com.fuctura.entity.Loja;

public interface ILojaRepository {

    Optional<Loja> findById(Connection connection, Integer codigo) throws SQLException;
    Loja save(Connection connection, Loja loja) throws SQLException;
}
