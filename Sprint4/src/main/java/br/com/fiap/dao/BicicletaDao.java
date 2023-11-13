package br.com.fiap.dao;
import br.com.fiap.entity.Bicicleta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BicicletaDao {
	private Connection conexao;

    public void inserir(Bicicleta bicicleta) {
        conexao = Conexao.obterConexao();
        PreparedStatement comandoSql = null;
        String sql = "insert into bicicleta (idBicicleta, modelo, marca, numeroSerie, numeroMarchas, cor, valor) values(?,?, ?, ?, ?, ?, ?)";
        try {
            comandoSql = conexao.prepareStatement(sql);
            comandoSql.setInt(1,bicicleta.getIdBicicleta());
            comandoSql.setString(2, bicicleta.getModelo());
            comandoSql.setString(3, bicicleta.getMarca());
            comandoSql.setString(4, bicicleta.getNumeroSerie());
            comandoSql.setString(5, bicicleta.getNumeroMarchas());
            comandoSql.setString(6, bicicleta.getCor());
            comandoSql.setDouble(7, bicicleta.getValor());
            comandoSql.executeUpdate();
            comandoSql.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
    public void excluir(int id)  {
    	conexao = Conexao.obterConexao();
    	PreparedStatement comandoSql = null;
        try{
            comandoSql = conexao.prepareStatement("delete from bicicleta where idBicicleta = ?");
            comandoSql.setInt(1,id);
            comandoSql.executeUpdate();
            conexao.close();
            comandoSql.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Bicicleta> buscarTodasBicicletas(){
		List<Bicicleta> listaBicicletas = new ArrayList<Bicicleta>();
		conexao = Conexao.obterConexao();
		PreparedStatement comandoSql = null;
		try {
			comandoSql = conexao.prepareStatement("select * from bicicleta");
			ResultSet rs = comandoSql.executeQuery();
			while(rs.next()) {
				Bicicleta p = new Bicicleta();
				p.setIdBicicleta(rs.getInt(1));
				p.setModelo(rs.getString(2));
				p.setMarca(rs.getString(3));
				p.setNumeroSerie(rs.getString(4));
				p.setNumeroMarchas(rs.getString(5));
				p.setCor(rs.getString(6));
				p.setValor(rs.getDouble(7));
				String tipo = rs.getString(7);
				listaBicicletas.add(p);
			}
			conexao.close();
			comandoSql.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaBicicletas;
	}
    public Bicicleta BuscarPorId(int id){  
    	Bicicleta p = new Bicicleta(); 
    	conexao = Conexao.obterConexao();
    	PreparedStatement comandoSql = null;
    		try{
    			comandoSql = conexao.prepareStatement("Select * from bicicleta where idBicicleta = ?");
    			comandoSql.setInt(1, id);
    			ResultSet rs = comandoSql.executeQuery();
    			
    			if(rs.next()){
    				p = new Bicicleta(); 
    				p.setIdBicicleta(rs.getInt(1));
    				p.setModelo(rs.getString(2));
    				p.setMarca(rs.getString(3));
    				p.setNumeroSerie(rs.getString(4));
    				p.setNumeroMarchas(rs.getString(5));
    				p.setCor(rs.getString(6));
    				p.setValor(rs.getDouble(7));
        }
        conexao.close();
        comandoSql.close();
    } catch (SQLException e){
        e.printStackTrace();
    }
    return p; 
    }
}

