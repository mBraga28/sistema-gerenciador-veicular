package br.com.fuctura.repository.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import br.com.fuctura.dao.VendaDAO;
import br.com.fuctura.entity.Venda;
import br.com.fuctura.repository.IVendaRepository;

public class VendaRepository implements IVendaRepository {

    private final VendaDAO vendaDAO;

    public VendaRepository() {
        this.vendaDAO = new VendaDAO();
    }

    @Override
    public Venda save(Connection connection, Venda venda) throws SQLException {
        return vendaDAO.save(connection, venda);
    }

    @Override
    public Optional<List<Venda>> findAll(Connection connection) throws SQLException {
        return vendaDAO.findAll(connection);
    }

    @Override
    public Optional<Venda> findById(Connection connection, Integer codigo) throws SQLException {
        return vendaDAO.findById(connection, codigo);
    }

    

}
