package br.com.fuctura.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import br.com.fuctura.entity.Venda;

public interface IVendaRepository {

    Venda save(Connection connection,Venda venda) throws SQLException;
    Optional<List<Venda>> findAll(Connection connection) throws SQLException;
    Optional<Venda> findById(Connection connection, Integer codigo) throws SQLException;    

}
