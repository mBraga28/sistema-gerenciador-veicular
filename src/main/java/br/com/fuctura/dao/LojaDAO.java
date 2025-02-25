package br.com.fuctura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import br.com.fuctura.entity.Loja;
import br.com.fuctura.entity.Veiculo;

public class LojaDAO {

    public Loja save(Connection connection, Loja loja) throws SQLException {

        String comandoSQL = "INSERT INTO loja (nome, endereco) VALUES (?, ?)";

        PreparedStatement ps = connection.prepareStatement(comandoSQL, PreparedStatement.RETURN_GENERATED_KEYS);

        ps.setString(1, loja.getNome());
        ps.setObject(2, loja.getEndereco().getCep());

        ps.execute();

        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            int idGerado = rs.getInt(1);
            loja.setCodigo(idGerado);
        }    

        return loja;

    }

    public Optional<Loja> findById(Connection connection, Integer codigo) throws SQLException{
		String comandoSQL = "select "
				+ "l.nome, v.placa, v.ano, v.valor "
				+ "from veiculo v \n"
				+ "inner join loja_veiculo lv \n"
				+ "on v.codigo = lv.cod_veiculo \n"
				+ "inner join loja l\n"
				+ "on l.codigo = lv.cod_loja \n"
				+ "where l.codigo = ?";
		
		System.out.println(comandoSQL);
		
		PreparedStatement pst = connection.prepareStatement(comandoSQL);
		
		pst.setInt(1, codigo);
		
		ResultSet rs = pst.executeQuery();
		
		Loja l = new Loja();
		
		while(rs.next()) {
			String nomeLoja = rs.getString("nome");
			String placaVeiculo = rs.getString("placa");
			Double valorVeiculo = rs.getDouble("valor");
			
			Veiculo v = new Veiculo();
			v.setPlaca(placaVeiculo);
			v.setValor(valorVeiculo);
			
			l.setNome(nomeLoja);
			
			l.add(v);
		}
		
		return Optional.of(l);
	}

}
