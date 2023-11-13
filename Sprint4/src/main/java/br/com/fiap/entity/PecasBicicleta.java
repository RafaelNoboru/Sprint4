package br.com.fiap.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PecasBicicleta {
	  private int idPecaBicicleta;
	    private String nomePeca;
	    private double preco;
	    private String fabricante;

	    public int getIdPecaBicicleta() {
	        return idPecaBicicleta;
	    }

	    public void setIdPecaBicicleta(int idPecaBicicleta) {
	        this.idPecaBicicleta = idPecaBicicleta;
	    }

	    public String getNomePeca() {
	        return nomePeca;
	    }

	    public void setNomePeca(String nomePeca) {
	        this.nomePeca = nomePeca;
	    }
	    public Double getPreco() {
	        return preco;
	    }

	    public void setPreco(Double preco) {
	        this.preco = preco;
	    }

	    public String getFabricante() {
	        return fabricante;
	    }

	    public void setFabricante(String fabricante) {
	        this.fabricante = fabricante;
	    }


	    public String ToString() {
	        return  "Dados das peças da Bicicleta" +
	                "\nId da peça: " + idPecaBicicleta +
	                "\nNome peça: " + nomePeca +
	                "\nPreço: " + preco +
	                "\nFabricante: " + fabricante;



	    }	
}
