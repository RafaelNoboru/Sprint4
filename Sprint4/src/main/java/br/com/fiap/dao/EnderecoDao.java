package br.com.fiap.dao;
import br.com.fiap.entity.Bicicleta;
import br.com.fiap.entity.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDao {
	
	private Connection conexao;

    public void inserir(Endereco endereco) {
        conexao = Conexao.obterConexao();
        PreparedStatement comandoSql = null;
        String sql = "insert into endereco (idEndereco,cep,rua,complemento,bairro,cidade,uf,numero) values(?,?,?,?,?,?,?,?)";

        try {
            comandoSql = conexao.prepareStatement(sql);
            comandoSql.setInt(1, endereco.getIdEndereco());
            comandoSql.setString(2, endereco.getCep());
            comandoSql.setString(3, endereco.getLogradouro());
            comandoSql.setString(4, endereco.getComplemento());
            comandoSql.setString(5, endereco.getBairro());
            comandoSql.setString(6, endereco.getLocalidade());
            comandoSql.setString(7, endereco.getUf());
            comandoSql.setString(8, endereco.getNumero());
            comandoSql.executeUpdate();
            comandoSql.close();
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }
    public void alterar(Endereco endereco)  {
        PreparedStatement comandoSql = null;
        try{
            comandoSql = conexao.prepareStatement("update endereco set cep = ?, rua = ?, complemento = ?, " +
                    "bairro = ?, cidade = ?, uf = ?, numero = ? where idEndereco = ?");
            comandoSql.setString(1, endereco.getCep());
            comandoSql.setString(2, endereco.getLogradouro()); 
            comandoSql.setString(3, endereco.getComplemento());
            comandoSql.setString(4, endereco.getBairro());
            comandoSql.setString(5, endereco.getLocalidade()); 
            comandoSql.setString(6, endereco.getUf());
            comandoSql.setString(7, endereco.getNumero());
            comandoSql.setInt(8,endereco.getIdEndereco());
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
            comandoSql = conexao.prepareStatement("delete from endereco where idEndereco = ?");
            comandoSql.setInt(1,id);
            comandoSql.executeUpdate();
            conexao.close();
            comandoSql.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Endereco> buscarTodosEnderecos(){
		List<Endereco> listaEnderecos = new ArrayList<Endereco>();
		conexao = Conexao.obterConexao();
		PreparedStatement comandoSql = null;
		try {
			comandoSql = conexao.prepareStatement("select * from endereco");
			ResultSet rs = comandoSql.executeQuery();
			while(rs.next()) {
				Endereco e = new Endereco();
				e.setCep(rs.getString(1));
				e.setLogradouro(rs.getString(2));
				e.setComplemento(rs.getString(3));
				e.setBairro(rs.getString(4));
				e.setLocalidade(rs.getString(5));
				e.setUf(rs.getString(6));
				e.setNumero(rs.getString(7));
				String tipo = rs.getString(7);
				listaEnderecos.add(e);
			}
			conexao.close();
			comandoSql.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaEnderecos;
	}

    public Endereco buscarPorId(int id){
        Endereco endereco = new Endereco();
        PreparedStatement comandoSql = null;
        try{
            comandoSql = conexao.prepareStatement("Select * from endereco where idEndereco = ?");
            comandoSql.setInt(1,id);
            ResultSet rs = comandoSql.executeQuery();
            if(rs.next()){
                endereco.setIdEndereco(rs.getInt(1));
                endereco.setCep(rs.getString(2));
                endereco.setLogradouro(rs.getString(3));
                endereco.setComplemento(rs.getString(4));
                endereco.setBairro(rs.getString(5));
                endereco.setLocalidade(rs.getString(6));
                endereco.setUf(rs.getString(7));
                endereco.setNumero(rs.getString(8));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return endereco;
    }
}

