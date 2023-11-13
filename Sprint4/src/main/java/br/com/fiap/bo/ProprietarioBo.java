package br.com.fiap.bo;

import java.util.List;

import br.com.fiap.dao.ProprietarioDao;
import br.com.fiap.entity.Proprietario;

public class ProprietarioBo {
	
private ProprietarioDao proprietarioDao;
	
	public void cadastrar(Proprietario proprietario) {
		proprietarioDao = new ProprietarioDao();
		proprietarioDao.inserir(proprietario);
}

	public List<Proprietario> buscarProprietarios(){
		proprietarioDao = new ProprietarioDao();
		return proprietarioDao.buscarTodosProprietarios();
	}
	public void atualizar(Proprietario proprietario) {
		proprietarioDao = new ProprietarioDao();
		proprietarioDao.alterar(proprietario);
	}
	
}
