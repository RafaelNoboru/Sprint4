package br.com.fiap.testes;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.fiap.entity.Endereco;

public class GeradorDeArquivo {
    
	public void gravaJson(Endereco endereco) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter file = new FileWriter(endereco.getCep() + ".json");
        file.write(gson.toJson(endereco));
        file.close();
    }
}
