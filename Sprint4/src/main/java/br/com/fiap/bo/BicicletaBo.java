package br.com.fiap.bo;
import java.util.List;


import br.com.fiap.dao.BicicletaDao;
import br.com.fiap.entity.Bicicleta;


public class BicicletaBo {
	
private BicicletaDao bicicletaDao;

	public void cadastrar(Bicicleta bicicleta) {
		bicicletaDao = new BicicletaDao();
		bicicletaDao.inserir(bicicleta);
}

	public List<Bicicleta> buscarBicicletas(){
		bicicletaDao = new BicicletaDao();
		return bicicletaDao.buscarTodasBicicletas();
	}
	 public Bicicleta buscarBicicletaPorId(int idBicicleta) {
	        try {
	            return bicicletaDao.BuscarPorId(idBicicleta);
	        } catch (Exception e) {
	            e.printStackTrace(); 
	            return null; 
	        }
	    }
	 }

