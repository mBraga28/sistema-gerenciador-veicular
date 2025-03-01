package br.com.fuctura.repository.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import br.com.fuctura.dao.VendedorDAO;
import br.com.fuctura.entity.Vendedor;
import br.com.fuctura.repository.IVendedorRepository;

public class VendedorRepository implements IVendedorRepository {

    private final VendedorDAO vendedorDAO;

    public VendedorRepository() {
        this.vendedorDAO = new VendedorDAO();
    }

    @Override
    public Vendedor save(Connection connection, Vendedor vendedor) throws SQLException {
        return vendedorDAO.save(connection, vendedor);
    }

    @Override
    public Optional<Vendedor> findById(Connection connection, Integer codigo) throws SQLException {
        return vendedorDAO.findById(connection, codigo);
    }

    @Override
    public Optional<Vendedor> findByNome(Connection connection, String nome) throws SQLException {
        return vendedorDAO.findByNome(connection, nome);
    }

    @Override
    public Optional<List<Vendedor>> findAll(Connection connection) throws SQLException {
        return vendedorDAO.findAll(connection);
    }
    
    @Override
    public Vendedor update(Connection connection, Vendedor vendedor) throws SQLException {
        return vendedorDAO.update(connection, vendedor);
    }

    @Override
    public Vendedor delete(Connection connection, Vendedor vendedor) throws SQLException {
        return vendedorDAO.delete(connection, vendedor);
    }

}
