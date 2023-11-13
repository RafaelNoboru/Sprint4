package br.com.fiap.testes;

import java.util.Scanner;

import br.com.fiap.dao.EnderecoDao;
import br.com.fiap.entity.Endereco;
import br.com.fiap.services.ViaCepService;

public class TesteInserirEndereco {
    public static void main(String[] args) {
    	
    	Scanner leitor = new Scanner(System.in);
        Scanner ent = new Scanner(System.in);
        ViaCepService consulta = new ViaCepService();
        
        Endereco meuEndereco = new Endereco();
        EnderecoDao enderecoDao = new EnderecoDao();  

        System.out.println("Digite o número do CEP para registro: ");
        var cep = leitor.nextLine();
        
        try {
            meuEndereco = consulta.buscaEndereco(cep);
            System.out.println(meuEndereco.toString());
            System.out.println("Digite o id: ");
            meuEndereco.setIdEndereco(ent.nextInt());
            System.out.println("Digite o número do endereço: ");
            meuEndereco.setNumero(leitor.nextLine());
            enderecoDao.inserir(meuEndereco); 
            
        	}catch (RuntimeException e) {
        		System.out.println(e.getMessage());
        }
    }
}
