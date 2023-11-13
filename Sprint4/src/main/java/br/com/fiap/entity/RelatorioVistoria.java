package br.com.fiap.entity;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RelatorioVistoria {
    
	private int idVistoria;
	private LocalDate dataVistoria;
    private String resultadoVistoria;
    private PecasBicicleta pecasBicicleta;

    public LocalDate getDataVistoria() {
        return dataVistoria;
    }

    public void setDataVistoria(LocalDate dataVistoria) {
        this.dataVistoria = dataVistoria;
    }

    public int getIdVistoria() {
        return idVistoria;
    }

    public void setIdVistoria(int idVistoria) {
        this.idVistoria = idVistoria;
    }

    public String getResultadoVistoria() {
        return resultadoVistoria;
    }

    public void setResultadoVistoria(String resultadoVistoria) {
        this.resultadoVistoria = resultadoVistoria;
    }

    public PecasBicicleta getPecasBicicleta() {
        return pecasBicicleta;
    }

    public void setPecasBicicleta(PecasBicicleta pecasBicicleta) {
        this.pecasBicicleta = pecasBicicleta;
    }

    public String toString() {
        return  "Id da Vistoria: " + idVistoria +
                "\nData Vistoria: " + dataVistoria +
                "\nResultado vistoria: " + resultadoVistoria +
                "\nId da peça: " + pecasBicicleta.getIdPecaBicicleta();


    }
}
