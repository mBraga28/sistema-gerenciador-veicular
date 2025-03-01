package br.com.fuctura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.fuctura.entity.Cliente;
import br.com.fuctura.entity.Loja;
import br.com.fuctura.entity.Veiculo;
import br.com.fuctura.entity.Venda;
import br.com.fuctura.entity.Vendedor;

public class VendaDAO {

    public Venda save(Connection connection, Venda venda) throws SQLException {
        String comandoSQL = "insert into venda (cod_cliente, cod_veiculo, cod_vendedor, cod_loja, valor, dh_venda)\n" + "values (?, ?, ?, ?, ?, ?)";
        
        PreparedStatement ps = connection.prepareStatement(comandoSQL, Statement.RETURN_GENERATED_KEYS);

        ps.setObject(1, venda.getCliente().getCodigo());
        ps.setObject(2, venda.getVeiculo().getCodigo());
        ps.setObject(3, venda.getVendedor().getCodigo());
        ps.setObject(4, venda.getLoja().getCodigo());
        ps.setDouble(5, venda.getValor());
        ps.setObject(6, venda.getDhVenda());
        
        ps.execute();
        
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            int idGerado = rs.getInt(1);
            venda.setCodigo(idGerado);

        }
        
        return venda;
    }
    
    public Optional<List<Venda>> findAll(Connection connection) throws SQLException {
        String comandoSQL = "select * from venda";
        
        PreparedStatement ps = connection.prepareStatement(comandoSQL);
        
        ResultSet rs = ps.executeQuery();
        
        List<Venda> lista = new ArrayList<Venda>();
        
        while (rs.next()) {
            Venda v = extracted(rs);
            lista.add(v);
        }
        
        return lista.isEmpty() ? Optional.empty() : Optional.of(lista);
    }

    public Optional<Venda> findById(Connection connection, Integer codigo) throws SQLException {
        String comandoSQL = "select * from venda where codigo = ?";
        
        PreparedStatement ps = connection.prepareStatement(comandoSQL);
        
        ps.setInt(1, codigo);
        
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Venda v = extracted(rs);
            return Optional.of(v);
        }
        
        return Optional.empty();
    }
    
    public Venda update(Connection connection, Venda venda) throws SQLException {
        String comandoSQL = "update venda set cod_cliente = ?, cod_veiculo = ?, cod_vendedor = ?, cod_loja = ?, valor = ?, dh_venda = ? where codigo = ?";
        
        PreparedStatement ps = connection.prepareStatement(comandoSQL);
        
        ps.setObject(1, venda.getCliente().getCodigo());
        ps.setObject(2, venda.getVeiculo().getCodigo());
        ps.setObject(3, venda.getVendedor().getCodigo());
        ps.setObject(4, venda.getLoja().getCodigo());
        ps.setDouble(5, venda.getValor());
        ps.setObject(6, venda.getDhVenda());
        ps.setInt(7, venda.getCodigo());
        
        ps.execute();
        
        return venda;
    }

    public Venda delete(Connection connection, Venda venda) throws SQLException {
        String comandoSQL = "delete from venda where codigo = ?";
        
        PreparedStatement ps = connection.prepareStatement(comandoSQL);
        
        ps.setInt(1, venda.getCodigo());
        
        ps.execute();
        
        return venda;
    }

    private Venda extracted(ResultSet rs) throws SQLException {
        int cod = rs.getInt("codigo");
        int codCliente = rs.getInt("cod_cliente");
        int codVeiculo = rs.getInt("cod_veiculo");
        int codVendedor = rs.getInt("cod_vendedor");
        int codLoja = rs.getInt("cod_loja");
        double valor = rs.getDouble("valor");
        Instant dhVenda = rs.getTimestamp("dh_venda").toInstant();
        
        Venda v = new Venda();
        v.setCodigo(cod);

        Cliente cliente = new Cliente();
        cliente.setCodigo(codCliente);
        v.setCliente(cliente);

        Veiculo veiculo = new Veiculo();
        veiculo.setCodigo(codVeiculo);
        v.setVeiculo(veiculo);

        Vendedor vendedor = new Vendedor();
        vendedor.setCodigo(codVendedor);
        v.setVendedor(vendedor);

        Loja loja = new Loja();
        loja.setCodigo(codLoja);
        v.setLoja(loja);

        v.setValor(valor);
        v.setDhVenda(dhVenda);
        
        return v;
    }
}
