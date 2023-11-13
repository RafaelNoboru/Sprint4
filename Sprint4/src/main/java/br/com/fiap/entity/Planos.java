package br.com.fiap.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Planos {

private int IdPlano;
private String plano;
private double cotacao;
private String beneficios;

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public double getCotacao() {
        return cotacao;
    }

    public void setCotacao(double cotacao) {
        this.cotacao = cotacao;
    }

    public int getIdPlano() {
        return IdPlano;
    }

    public void setIdPlano(int idPlano) {
        IdPlano = idPlano;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }

    public String mostrarPlano(){
        return  "Plano: " + plano +
                "\nBenefícios: " + beneficios +
                "\nValor do plano: " + cotacao;

    }
}
