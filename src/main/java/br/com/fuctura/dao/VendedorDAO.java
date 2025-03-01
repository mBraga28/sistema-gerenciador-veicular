package br.com.fuctura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.fuctura.entity.Vendedor;

public class VendedorDAO {

    public Vendedor save(Connection connection, Vendedor vendedor) throws SQLException {
        String comandoSQL = "insert into vendedor (nome, cpf, email, telefone) values (?, ?, ?, ?)";
        PreparedStatement pstm = connection.prepareStatement(comandoSQL, Statement.RETURN_GENERATED_KEYS);

        pstm.setString(1, vendedor.getNome());

        pstm.execute();

        ResultSet rs = pstm.getGeneratedKeys();
        if (rs.next()) {
            int idGerado = rs.getInt(1);
            vendedor.setCodigo(idGerado);
        }

        return vendedor;     

    }

    public Optional<List<Vendedor>> findAll(Connection connection) throws SQLException {
        String comandoSQL = "select * from vendedor";
        PreparedStatement pstm = connection.prepareStatement(comandoSQL);
        ResultSet rs = pstm.executeQuery();

        List<Vendedor> lista = new ArrayList<Vendedor>();

        while (rs.next()) {
            Vendedor v = extracted(rs);
            lista.add(v);
        }
        return Optional.of(lista);
    }

    public Optional<Vendedor> findById(Connection connection, Integer codigo) throws SQLException {
        String comandoSQL = "select * from vendedor where codigo = ?";
        PreparedStatement pstm = connection.prepareStatement(comandoSQL);
        pstm.setInt(1, codigo);
        ResultSet rs = pstm.executeQuery();

        if (rs.next()) {
            Vendedor v = extracted(rs);
            return Optional.of(v);
        }

        return Optional.empty();
    }       

    public Optional<Vendedor> findByNome(Connection connection, String nome) throws SQLException {
        String comandoSQL = "select * from vendedor where nome = ?";
        PreparedStatement pstm = connection.prepareStatement(comandoSQL);
        pstm.setString(1, nome);
        ResultSet rs = pstm.executeQuery();

        if (rs.next()) {
            Vendedor vendedor = extracted(rs);
            return Optional.of(vendedor);
        }

        return Optional.empty();
    }

    public Vendedor update(Connection connection, Vendedor vendedor) throws SQLException {
        String comandoSQL = "update vendedor set nome = ? where codigo = ?";
        PreparedStatement pstm = connection.prepareStatement(comandoSQL);

        pstm.setString(1, vendedor.getNome());
        pstm.setInt(5, vendedor.getCodigo());

        pstm.execute();

        return vendedor;
    }

    public Vendedor delete(Connection connection, Vendedor vendedor) throws SQLException {
        String comandoSQL = "delete from vendedor where codigo = ?";
        PreparedStatement pstm = connection.prepareStatement(comandoSQL);
        pstm.setInt(1, vendedor.getCodigo());
        pstm.execute();
        return vendedor;
    }

    private Vendedor extracted(ResultSet rs) throws SQLException {
        Vendedor v = new Vendedor();
        v.setCodigo(rs.getInt("codigo"));
        v.setNome(rs.getString("nome"));
        return v;
    }

}
