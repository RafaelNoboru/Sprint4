package br.com.fiap.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Proprietario {
	
	private int idProprietario;
	private String nome;
    private String RG;
    private String cpf;
    private String telefone;
    private String email;
    private Endereco endereco;
    private Bicicleta bicicleta;

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getCpf() {
        return cpf;
    }

    public Bicicleta getBicicleta() {
		return bicicleta;
	}

	public void setBicicleta(Bicicleta bicicleta) {
		this.bicicleta = bicicleta;
	}

	public String toString() {
        return "Dados proprietário" +
                "Id proprietario: " + idProprietario +
        		"Nome: " + nome +
                "\nRG: " + RG +
                "\nCpf: " + cpf +
                "\nTelefone: " + telefone +
                "\nEmail: " + email +
                "\nEndereço: " +
                "\nCep: " + endereco.getCep() +
                "\nRua: " + endereco.getLogradouro() +
                "\nComplemento: " + endereco.getComplemento() +
                "\nBairro: " + endereco.getBairro() +
                "\nCidade: " + endereco.getLocalidade() +
                "\nEstado: " + endereco.getUf() +
                "\nNúmero: " + endereco.getNumero() +
        		"\nBicicleta: " +
                "\nModelo: " + bicicleta.getModelo() +
                "\nMarca: " + bicicleta.getMarca() +
                "\nNumero de Serie: " + bicicleta.getNumeroSerie() +
                "\nNumero de Marchas: " + bicicleta.getNumeroMarchas() +
                "\nCor: " + bicicleta.getCor() +
                "\nValor: " + bicicleta.getValor();

    }

    public void setCpf(String cpf) {
        if (cpf.length() != 11) {
            System.out.println("CPF inválido");
            throw new IllegalArgumentException();
        }
        this.cpf = cpf;
    }

	public int getIdProprietario() {
		return idProprietario;
	}

	public void setIdProprietario(int idProprietario) {
		this.idProprietario = idProprietario;
	}
}
