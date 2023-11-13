package br.com.fiap.dao;
import br.com.fiap.entity.Endereco;
import br.com.fiap.entity.RelatorioVistoria;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RelatorioVistoriaDao {
	private Connection conexao;
    public void inserir(RelatorioVistoria relatorioVistoria){
        conexao = Conexao.obterConexao();
        PreparedStatement comandoSql = null;
        String sql = "insert into relatorio (idVistoria, dataVistoria, resultadoVistoria) values(?,?,?)";

        try {
            comandoSql = conexao.prepareStatement(sql);
            comandoSql.setInt(1, relatorioVistoria.getIdVistoria());

            LocalDate dataVistoria = relatorioVistoria.getDataVistoria();
            if (dataVistoria != null) {
                comandoSql.setDate(2, Date.valueOf(dataVistoria));
            } else {
                throw new IllegalArgumentException("A data da vistoria não pode ser nula.");
            }

            comandoSql.setString(3, relatorioVistoria.getResultadoVistoria());
            comandoSql.executeUpdate();
            comandoSql.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void excluir(int id)  {
        PreparedStatement comandoSql = null;
        try{
            comandoSql = conexao.prepareStatement("delete from endereco where idVistoria = ?");
            comandoSql.setInt(1,id);
            comandoSql.executeUpdate();
            conexao.close();
            comandoSql.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<RelatorioVistoria> buscarTodosRelatorios(){
		List<RelatorioVistoria> listaRelatorios = new ArrayList<RelatorioVistoria>();
		conexao = Conexao.obterConexao();
		PreparedStatement comandoSql = null;
		try {
			comandoSql = conexao.prepareStatement("select * from relatorioVistoria");
			ResultSet rs = comandoSql.executeQuery();
			while(rs.next()) {
				RelatorioVistoria rv = new RelatorioVistoria();
				rv.setIdVistoria(rs.getInt(1));
				rv.setDataVistoria(null);
				rv.setResultadoVistoria(rs.getString(3));
				String tipo = rs.getString(3);
				listaRelatorios.add(rv);
			}
			conexao.close();
			comandoSql.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaRelatorios;
	}

    public RelatorioVistoria buscarPorId(int id){
        RelatorioVistoria relatoriovistoria = new RelatorioVistoria();
        PreparedStatement comandoSql = null;
        try{
            comandoSql = conexao.prepareStatement("Select * from relatoriovistoria where idVistoria = ?");
            comandoSql.setInt(1,id);
            ResultSet rs = comandoSql.executeQuery();
            if(rs.next()){
                relatoriovistoria.setIdVistoria(rs.getInt(1));
                relatoriovistoria.setDataVistoria(null);
                relatoriovistoria.setResultadoVistoria(rs.getString(3));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return relatoriovistoria;
    }
}
