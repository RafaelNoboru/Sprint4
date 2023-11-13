package br.com.fiap.dao;


import br.com.fiap.entity.Proprietario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProprietarioDao {
	private Connection conexao;
    public void inserir(Proprietario proprietario){
        conexao = Conexao.obterConexao();
        PreparedStatement comandoSql = null;
        String sql = "insert into proprietario (idProprietario, nome,RG,cpf,telefone,email, idEnderecoProprietario, idBicicletaProprietario) values(?,?,?,?,?,?,?,?)";
       try {

           comandoSql = conexao.prepareStatement(sql);
           comandoSql.setInt(1,proprietario.getIdProprietario());
           comandoSql.setString(2, proprietario.getNome());
           comandoSql.setString(3, proprietario.getRG());
           comandoSql.setString(4, proprietario.getCpf());
           comandoSql.setString(5, proprietario.getTelefone());
           comandoSql.setString(6, proprietario.getEmail());
           comandoSql.setInt(7, proprietario.getEndereco().getIdEndereco());
           comandoSql.setInt(8, proprietario.getBicicleta().getIdBicicleta());
           comandoSql.executeUpdate();
           comandoSql.close();
           conexao.close();

       }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void alterar(Proprietario proprietario)  {
        PreparedStatement comandoSql = null;
        try{
            comandoSql = conexao.prepareStatement("update proprietario set telefone = ?, email = ? where idProprietario = ?");
            comandoSql.setString(1, proprietario.getTelefone());
            comandoSql.setString(2, proprietario.getEmail()); 
           
            comandoSql.executeUpdate();
            conexao.close();
            comandoSql.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void excluir(int id)  {
        PreparedStatement comandoSql = null;
        try{
            comandoSql = conexao.prepareStatement("delete from proprietario where idProprietario = ?");
            comandoSql.setInt(1,id);
            comandoSql.executeUpdate();
            conexao.close();
            comandoSql.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } public List<Proprietario> buscarTodosProprietarios(){
		List<Proprietario> listaProprietarios = new ArrayList<Proprietario>();
		conexao = Conexao.obterConexao();
		PreparedStatement comandoSql = null;
		try {
			comandoSql = conexao.prepareStatement("select * from proprietario");
			ResultSet rs = comandoSql.executeQuery();
			while(rs.next()) {
				Proprietario pr = new Proprietario();
				pr.setIdProprietario(rs.getInt(1));
				pr.setNome(rs.getString(2));
				pr.setRG(rs.getString(3));
				pr.setCpf(rs.getString(4));
				pr.setTelefone(rs.getString(5));
				pr.setEmail(rs.getString(6));
				String tipo = rs.getString(6);
				listaProprietarios.add(pr);
			}
			conexao.close();
			comandoSql.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaProprietarios;
	}

    public Proprietario buscarPorId(int id){
    	Proprietario proprietario = new Proprietario();
        
    	PreparedStatement comandoSql = null;
        try{
            comandoSql = conexao.prepareStatement("Select * from proprietario where idProprietario = ?");
            comandoSql.setInt(1,id);
            ResultSet rs = comandoSql.executeQuery();
            if(rs.next()){
                proprietario.setIdProprietario(rs.getInt(1));
            	proprietario.setNome(rs.getString(2));
                proprietario.setRG(rs.getString(3));
                proprietario.setCpf(rs.getString(4));
                proprietario.setTelefone(rs.getString(5));
                proprietario.setEmail(rs.getString(6));
               
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return proprietario;
    }
}
