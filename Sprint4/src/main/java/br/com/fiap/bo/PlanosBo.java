package br.com.fiap.bo;

import java.util.List;

import br.com.fiap.dao.PlanosDao;
import br.com.fiap.entity.Planos;

public class PlanosBo {
	
	private PlanosDao planosDao;
	
	public void cadastrar(Planos planos) {
		planosDao = new PlanosDao();
		planosDao.inserir(planos);
}

	public List<Planos> buscarPlanos(){
		planosDao = new PlanosDao();
		return planosDao.buscarPlanos();
	}

}
