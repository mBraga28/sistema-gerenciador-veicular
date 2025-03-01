package br.com.fuctura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.fuctura.entity.Tipo;
import br.com.fuctura.entity.Veiculo;

public class VeiculoDAO {

    public Veiculo save(Connection connection, Veiculo veiculo) throws SQLException {
		String comandoSQL = "insert into veiculo (placa, modelo, ano, valor) values (?, ?, ?, ?)";
    PreparedStatement pstm = connection.prepareStatement(comandoSQL, Statement.RETURN_GENERATED_KEYS);

    pstm.setString(1, veiculo.getPlaca());
    pstm.setString(2, veiculo.getModelo());
    pstm.setInt(3, veiculo.getAno());
    pstm.setDouble(4, veiculo.getValor());

    pstm.executeUpdate();

    ResultSet rs = pstm.getGeneratedKeys();
    if (rs.next()) {
        int idGerado = rs.getInt(1);
        veiculo.setCodigo(idGerado);
    }

    // Insere a relação na join table veiculo_tipo
    String comandoSQLRel = "insert into veiculo_tipo (codigo_veiculo, codigo_tipo) values (?, ?)";
    PreparedStatement pstmRel = connection.prepareStatement(comandoSQLRel);
    pstmRel.setInt(1, veiculo.getCodigo());
    pstmRel.setInt(2, veiculo.getTipo().getCodigo());
    pstmRel.executeUpdate();

    return veiculo;
	}
	
	public Optional<List<Veiculo>> findAll(Connection connection) throws SQLException {
		String comandoSQL = "select * from veiculo";

		PreparedStatement pst = connection.prepareStatement(comandoSQL);

		ResultSet rs = pst.executeQuery();

		List<Veiculo> lista = new ArrayList<Veiculo>();
		
		while (rs.next()) {
			
			Veiculo v = extracted(rs);
			
			lista.add(v);
		}
		
		return lista.isEmpty() ? Optional.empty() : Optional.of(lista);
	}

	public Optional<Veiculo> findByPlaca(Connection connection, String placa) throws SQLException {
		String comandoSQL = "select * from veiculo where placa = ?";

		PreparedStatement pst = connection.prepareStatement(comandoSQL);	
		pst.setString(2, placa);
		
		ResultSet rs = pst.executeQuery();

		while (rs.next()) {
			Veiculo v = extracted(rs);
			return Optional.of(v);
		}
		return Optional.empty();
	}	

	public Veiculo update(Connection connection, Veiculo veiculo) throws SQLException {
		String comandoSQL = "update veiculo set placa = ?, modelo = ?, ano = ?, valor = ?, codigo_tipo = ? where codigo = ?";

		PreparedStatement ps = connection.prepareStatement(comandoSQL);

		ps.setString(1, veiculo.getPlaca());
		ps.setString(2, veiculo.getModelo());
		ps.setInt(3, veiculo.getAno());
		ps.setDouble(4, veiculo.getValor());
		ps.setInt(5, veiculo.getTipo().getCodigo());
		ps.setInt(7, veiculo.getCodigo());

		ps.execute();

		return veiculo;
	}

	public Veiculo delete(Connection connection, Veiculo veiculo) throws SQLException {
		String comandoSQL = "delete from veiculo where codigo = ?";

		PreparedStatement ps = connection.prepareStatement(comandoSQL);

		ps.setInt(1, veiculo.getCodigo());

		ps.execute();

		return veiculo;
	}
	
	private Veiculo extracted(ResultSet rs) throws SQLException {
		int cod = rs.getInt("codigo");
		int ano = rs.getInt("ano");
		double valor = rs.getDouble("valor");
		String modelo = rs.getString("modelo");
		String placa = rs.getString("placa");
		int codTipo = rs.getInt("codigo_tipo");

		Tipo tipo = new Tipo();
		tipo.setCodigo(codTipo);
		Veiculo v = new Veiculo(placa, modelo, ano, valor, tipo);
		v.setCodigo(cod);
		return v;
	}

}
