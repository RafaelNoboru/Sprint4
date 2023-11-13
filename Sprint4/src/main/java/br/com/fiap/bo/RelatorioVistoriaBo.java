package br.com.fiap.bo;

import java.util.List;

import br.com.fiap.dao.RelatorioVistoriaDao;
import br.com.fiap.entity.RelatorioVistoria;

public class RelatorioVistoriaBo {
	
	private RelatorioVistoriaDao relatorioVistoriaDao;
	
	public void cadastrar(RelatorioVistoria relatorioVistoria) {
		relatorioVistoriaDao = new RelatorioVistoriaDao();
		relatorioVistoriaDao.inserir(relatorioVistoria);
}

	public List<RelatorioVistoria> buscarRelatorios(){
		relatorioVistoriaDao = new RelatorioVistoriaDao();
		return relatorioVistoriaDao.buscarTodosRelatorios();
	}
}
