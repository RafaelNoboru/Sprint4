package br.com.fiap.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Bicicleta {
		private int idBicicleta;
	    private String modelo;
	    private String marca;
	    private String numeroSerie;
	    private String numeroMarchas;
	    private String cor;
	    private double valor;
	    public int getIdBicicleta() {
	        return idBicicleta;
	    }

	    public void setIdBicicleta(int idBicicleta) {
	        this.idBicicleta = idBicicleta;
	    }

	    public String getModelo() {
	        return modelo;
	    }

	    public void setModelo(String modelo) {
	        this.modelo = modelo;
	    }

	    public String getMarca() {
	        return marca;
	    }

	    public void setMarca(String marca) {
	        this.marca = marca;
	    }

	    public String getNumeroSerie() {
	        return numeroSerie;
	    }

	    public void setNumeroSerie(String numeroSerie) {
	        this.numeroSerie = numeroSerie;
	    }

	    public String getNumeroMarchas() {
	        return numeroMarchas;
	    }

	    public void setNumeroMarchas(String numeroMarchas) {
	        this.numeroMarchas = numeroMarchas;
	    }

	    public String getCor() {
	        return cor;
	    }
	    public void setCor(String cor) {
	        this.cor = cor;
	    }
	    public double getValor() {
	        return valor;
	    }

	    public void setValor(double valor){
	        if(valor < 2000){
	            System.out.println("Bicicletas no valor abaixo de R$2000 não são elegiveis para o seguro. ");
	            throw new IllegalArgumentException();
	        }
	        this.valor = valor;
	    }


	    public String toString() {
	        return  "IdBicicleta: " + idBicicleta +
	                "\nModelo: " + modelo +
	                "\nMarca: " + marca +
	                "\nNumero de serie: " + numeroSerie +
	                "\nNumero de marchas: " + numeroMarchas +
	                "\nCor: " + cor +
	                "\nValor: " + valor;
	    }
}
