package br.com.fuctura.repository.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import br.com.fuctura.dao.ClienteDAO;
import br.com.fuctura.entity.Cliente;
import br.com.fuctura.repository.IClienteRepository;

public class ClienteRepository implements IClienteRepository {

    private final ClienteDAO clienteDAO;

    public ClienteRepository() {
        this.clienteDAO = new ClienteDAO();
    }

    @Override
    public Cliente save(Connection connection, Cliente cliente) throws SQLException {
        return clienteDAO.save(connection, cliente);
    }

    @Override
    public Optional<List<Cliente>> findAll(Connection connection) throws SQLException {
        return clienteDAO.findAll(connection);
    }

    @Override
    public Optional<Cliente> findById(Connection connection, Integer codigo) throws SQLException {
        return clienteDAO.findById(connection, codigo);
    }

    @Override
    public Cliente update(Connection connection, Cliente cliente) throws SQLException {
        return clienteDAO.update(connection, cliente);
    }

    @Override
    public Cliente delete(Connection connection, Cliente cliente) throws SQLException {
        return clienteDAO.delete(connection, cliente);
    }



}
