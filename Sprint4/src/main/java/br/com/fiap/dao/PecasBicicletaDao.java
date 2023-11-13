package br.com.fiap.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.entity.PecasBicicleta;

public class PecasBicicletaDao {
	private Connection conexao;
    public void inserir(br.com.fiap.entity.PecasBicicleta pecasBicicleta) {
        conexao = Conexao.obterConexao();
        PreparedStatement comandoSql = null;
        String sql = "insert into pecasBicicleta (idPecaBicicleta,nomePeca,preco,fabricante) values(?,?,?,?)";

        try {
            comandoSql = conexao.prepareStatement(sql);
            comandoSql.setInt(1, pecasBicicleta.getIdPecaBicicleta());
            comandoSql.setString(2, pecasBicicleta.getNomePeca());
            comandoSql.setDouble(3, pecasBicicleta.getPreco());
            comandoSql.setString(4,pecasBicicleta.getFabricante());
            comandoSql.executeUpdate();
            comandoSql.close();
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }
    public void excluir(int id)  {
        PreparedStatement comandoSql = null;
        try{
            comandoSql = conexao.prepareStatement("delete from endereco where idPecaBicicleta = ?");
            comandoSql.setInt(1,id);
            comandoSql.executeUpdate();
            conexao.close();
            comandoSql.close();
        } catch (SQLException e) {
            e.printStackTrace();
            }
        }
    public List<PecasBicicleta> buscarTodasPecas(){
    		List<PecasBicicleta> listaPecas = new ArrayList<PecasBicicleta>();
    		conexao = Conexao.obterConexao();
    		PreparedStatement comandoSql = null;
    		try {
    			comandoSql = conexao.prepareStatement("select * from PecasBicicleta");
    			ResultSet rs = comandoSql.executeQuery();
    			while(rs.next()) {
    				PecasBicicleta pb = new PecasBicicleta();
    				pb.setIdPecaBicicleta(rs.getInt(1));
    				pb.setNomePeca(rs.getString(2));
    				pb.setPreco(rs.getDouble(3));
    				pb.setFabricante(rs.getString(4));
    				String tipo = rs.getString(4);
    				listaPecas.add(pb);
    			}
    			conexao.close();
    			comandoSql.close();
    		}catch (SQLException e) {
    			e.printStackTrace();
    		}
    		
    		return listaPecas;
    	}
    public PecasBicicleta buscarPorId(int id){
        PecasBicicleta pecasbicicleta = new PecasBicicleta();
        PreparedStatement comandoSql = null;
        try{
            comandoSql = conexao.prepareStatement("Select * from endereco where idPecaBicicleta = ?");
            comandoSql.setInt(1,id);
            ResultSet rs = comandoSql.executeQuery();
            if(rs.next()){
            	pecasbicicleta.setIdPecaBicicleta(rs.getInt(1));
            	pecasbicicleta.setNomePeca(rs.getString(2));
                pecasbicicleta.setPreco(rs.getDouble(3));
                pecasbicicleta.setFabricante(rs.getString(4));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return pecasbicicleta;
    }
    
}
