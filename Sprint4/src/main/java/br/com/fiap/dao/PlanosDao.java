package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import br.com.fiap.entity.Planos;

public class PlanosDao {
   
private Connection conexao;
    public void inserir(Planos planos){
        conexao = Conexao.obterConexao();
        PreparedStatement comandoSql = null;
        String sql = "insert into planos (idPlano,plano,cotacao,beneficios) values(?,?,?,?)";
        
    try{
    	comandoSql = conexao.prepareStatement(sql);
        comandoSql.setInt(1,planos.getIdPlano());
        comandoSql.setString(2,planos.getPlano());
        comandoSql.setDouble(3,planos.getCotacao());
        comandoSql.setString(4,planos.getBeneficios());
        comandoSql.executeUpdate();
        comandoSql.close();
        conexao.close();
    }catch (SQLException e) {
        throw new RuntimeException(e);
        }
    }
        
    public List<Planos> buscarPlanos(){
		List<Planos> listaPlanos = new ArrayList<Planos>();
		conexao = Conexao.obterConexao();
		PreparedStatement comandoSql = null;
		try {
			comandoSql = conexao.prepareStatement("select * from planos");
			ResultSet rs = comandoSql.executeQuery();
			while(rs.next()) {
				Planos pl = new Planos();
				pl.setIdPlano(rs.getInt(1));
				pl.setPlano(rs.getString(2));
				pl.setCotacao(rs.getDouble(3));
				pl.setBeneficios(rs.getString(4));
				String tipo = rs.getString(4);
				listaPlanos.add(pl);
			}
			conexao.close();
			comandoSql.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaPlanos;
	}
}
