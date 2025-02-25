package br.com.fuctura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.fuctura.entity.Cliente;
import br.com.fuctura.entity.Endereco;

public class ClienteDAO {

    public Cliente save(Connection connection ,Cliente cliente) throws SQLException {

        String comendoSQL = "insert into cliente (nome, cpf, celular, endereco) values (?, ?, ?, ?)";

        PreparedStatement ps = connection.prepareStatement(comendoSQL, Statement.RETURN_GENERATED_KEYS);

        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getCpf());
        ps.setString(3, cliente.getCelular());
        ps.setObject(4, cliente.getEndereco().getCep());

        try {
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int idGerado = rs.getInt(1);
                cliente.setCodigo(idGerado);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return cliente;
    }

    public Optional<List<Cliente>> findAll(Connection connection) throws SQLException {

        String comandoSQL = "select * from cliente";

        PreparedStatement ps = connection.prepareStatement(comandoSQL);

        ResultSet rs = ps.executeQuery();
        
        List<Cliente> lista = new ArrayList<Cliente>();

        while (rs.next()) {
            Cliente c = extracted(rs);
            lista.add(c);
        }

        return lista.isEmpty() ? Optional.empty() : Optional.of(lista);
    }

    public Optional<Cliente> findById(Connection connection, Integer codigo) throws SQLException {

        String comandoSQL = "select * from cliente where codigo = ?";

        PreparedStatement ps = connection.prepareStatement(comandoSQL);

        ps.setInt(1, codigo);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            Cliente c = extracted(rs);
            return Optional.of(c);
        }

        return Optional.empty();
    }

    public Cliente update(Connection connection, Cliente cliente) throws SQLException {

        String comandoSQL = "update cliente set nome = ?, cpf = ?, celular = ?, endereco = ? where codigo = ?";

        PreparedStatement ps = connection.prepareStatement(comandoSQL);

        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getCpf());
        ps.setString(3, cliente.getCelular());
        ps.setObject(4, cliente.getEndereco().getCep());
        ps.setInt(5, cliente.getCodigo());

        ps.execute();

        return cliente;
    }

    public void delete(Connection connection, Integer codigo) throws SQLException {

        String comandoSQL = "delete from cliente where codigo = ?";

        PreparedStatement ps = connection.prepareStatement(comandoSQL);

        ps.setInt(1, codigo);

        ps.execute();
    }

    private Cliente extracted(ResultSet rs) throws SQLException {
        int cod = rs.getInt("codigo");
        String nome = rs.getString("nome");
        String cpf = rs.getString("cpf");
        String celular = rs.getString("celular");
        String cepEnd = rs.getString("endereco");

        Cliente c = new Cliente();
        c.setCodigo(cod);
        c.setNome(nome);
        c.setCpf(cpf);
        c.setCelular(celular);

        Endereco endereco = new Endereco();
        endereco.setCep(cepEnd);
        c.setEndereco(endereco); 

        return c;
    }    

}
