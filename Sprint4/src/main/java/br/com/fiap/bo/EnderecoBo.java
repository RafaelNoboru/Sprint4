package br.com.fiap.bo;

import java.util.List;

import br.com.fiap.dao.EnderecoDao;
import br.com.fiap.entity.Endereco;

public class EnderecoBo {

	private EnderecoDao enderecoDao;
	
	public void cadastrar(Endereco endereco) {
		enderecoDao = new EnderecoDao();
		enderecoDao.inserir(endereco);
}

	public List<Endereco> buscarEnderecos(){
		enderecoDao = new EnderecoDao();
		return enderecoDao.buscarTodosEnderecos();
	}
}
