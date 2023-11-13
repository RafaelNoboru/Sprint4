package br.com.fiap.testes;

import java.util.ArrayList;
import java.util.List;
import br.com.fiap.dao.BicicletaDao;
import br.com.fiap.entity.Bicicleta;
public class TesteBuscarTodos {

	public static void main(String[] args) {
	
		BicicletaDao bicicletaDao = new BicicletaDao();
		
		// TODO Auto-generated method stub
		List<Bicicleta> bicicletas = new ArrayList<Bicicleta>();
		String dadosBicicletas = "";
		bicicletas = bicicletaDao.buscarTodasBicicletas(); // Supondo que bicicletaDao seja o objeto que acessa os dados
				
		for (Bicicleta bicicleta : bicicletas) {
		    dadosBicicletas += "======================\n";
		    dadosBicicletas += "ID da Bicicleta: " + bicicleta.getIdBicicleta() + "\n";
		    dadosBicicletas += "Modelo: " + bicicleta.getModelo() + "\n";
		    dadosBicicletas += "Marca: " + bicicleta.getMarca() + "\n";
		    dadosBicicletas += "Número de Série: " + bicicleta.getNumeroSerie() + "\n";
		    dadosBicicletas += "Número de Marchas: " + bicicleta.getNumeroMarchas() + "\n";
		    dadosBicicletas += "Cor: " + bicicleta.getCor() + "\n";
		    dadosBicicletas += "Valor: " + bicicleta.getValor() + "\n";
		    dadosBicicletas += "======================\n";
		}

		System.out.println(dadosBicicletas);
	}
}
