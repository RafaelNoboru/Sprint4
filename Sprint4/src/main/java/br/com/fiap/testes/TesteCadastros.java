package br.com.fiap.testes;
import br.com.fiap.dao.*;
import br.com.fiap.entity.*;

import java.util.Scanner;

public class TesteCadastros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

        Scanner numero = new Scanner(System.in);
        Scanner texto = new Scanner(System.in);
		
		Bicicleta bicicleta = new Bicicleta();

//	        System.out.println("Digite um ID para a bicicleta: ");
//	        bicicleta.setIdBicicleta(numero.nextInt());
//	        System.out.println("Digite o modelo da bicicleta: ");
//	        bicicleta.setModelo(texto.nextLine());
//	        System.out.println("Digite a marca/fabricante: ");
//	        bicicleta.setMarca(texto.nextLine());
//	        System.out.println("Digite o número de série: ");
//	        bicicleta.setNumeroSerie(texto.nextLine());
//	        System.out.println("Digite o número de marchas: ");
//	        bicicleta.setNumeroMarchas(texto.nextLine());
//	        System.out.println("Digite a cor da bicicleta: ");
//	        bicicleta.setCor(texto.nextLine());
//	        System.out.println("Digite o valor da bicicleta em R$: ");
//	        bicicleta.setValor(numero.nextDouble());

	        BicicletaDao bicicletaDao = new BicicletaDao();
	        
//	        bicicletaDao.inserir(bicicleta);
	        
//	        System.out.println("Digite o id para excluir um registro de bicicleta: "); 
//	        bicicletaDao.excluir(numero.nextInt());
//	        
	        System.out.println("Digite o id para buscar um registro de bicicleta: "); 
	        System.out.println(bicicletaDao.BuscarPorId(numero.nextInt()));
	        
	}

}
