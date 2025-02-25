package br.com.fuctura.repository.impl;

import java.sql.Connection;
import java.sql.SQLException;
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

}
