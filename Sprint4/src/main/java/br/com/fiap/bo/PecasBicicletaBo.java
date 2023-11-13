package br.com.fiap.bo;

import java.util.List;

import br.com.fiap.dao.PecasBicicletaDao;
import br.com.fiap.entity.PecasBicicleta;

public class PecasBicicletaBo {
	
	private PecasBicicletaDao pecasBicicletaDao;
	
	public void cadastrar(PecasBicicleta pecasbicicleta) {
		pecasBicicletaDao = new PecasBicicletaDao();
		pecasBicicletaDao.inserir(pecasbicicleta);
}

	public List<PecasBicicleta> buscarPecas(){
		pecasBicicletaDao = new PecasBicicletaDao();
		return pecasBicicletaDao.buscarTodasPecas();
	}
}
