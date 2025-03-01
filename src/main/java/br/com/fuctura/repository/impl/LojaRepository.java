package br.com.fuctura.repository.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import br.com.fuctura.dao.LojaDAO;
import br.com.fuctura.entity.Loja;
import br.com.fuctura.repository.ILojaRepository;

public class LojaRepository implements ILojaRepository {

    private final LojaDAO lojaDAO;

    public LojaRepository() {
        this.lojaDAO = new LojaDAO();
    }

    @Override
    public Loja save(Connection connection, Loja loja) throws SQLException {
        return lojaDAO.save(connection, loja);
    }

    @Override
    public Optional<Loja> findById(Connection connection, Integer codigo) throws SQLException {
        return lojaDAO.findById(connection, codigo);
    }

    @Override
    public Optional<Loja> findByNome(Connection connection, String nome) throws SQLException {
        return lojaDAO.findByNome(connection, nome);
    }

    @Override
    public Loja update(Connection connection, Loja loja) throws SQLException {
        return lojaDAO.update(connection, loja);
    }

    @Override
    public Loja delete(Connection connection, Loja loja) throws SQLException {
        return lojaDAO.delete(connection, loja);
    }

    @Override
    public Optional<List<Loja>> findAll(Connection connection) throws SQLException {
        return lojaDAO.findAll(connection);
    }

}
