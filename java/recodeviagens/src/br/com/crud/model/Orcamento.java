package br.com.crud.model;

import java.util.Date;
public class Orcamento extends Passagem {
	
	    private int idOrcamento, quantidade, idPassagem;
	    private Date dataIda, dataVolta;
	    private String destino, cpf;
	    private float precoTotal;
	    
	    

	    public int getIdOrcamento() {
	        return idOrcamento;
	    }
	    

	    public void setIdOrcamento(int idOrcamento) {
	        this.idOrcamento = idOrcamento;
	    }
	    

	    
	    public int getQuantidade() {
	        return quantidade;
	    }
	    

	    public void setQuantidade(int quantidade) {
	        this.quantidade = quantidade;
	    }
	    
	    
	    
	    public int getIdPassagem() {
	        return  idPassagem;
	    }
	    

	    public void setIdPassagem(int  idPassagem) {
	        this. idPassagem =  idPassagem;
	    }
	    
	    
	    public Date getDataIda() {
	        return dataIda;
	    }
	    

	    public void setDataIda(Date dataIda) {
	        this.dataIda = dataIda;
	    }
	    
	    
	    public Date getDataVolta() {
	        return dataVolta;
	    }
	    

	    public void setDataVolta(Date dataVolta) {
	        this.dataVolta = dataVolta;
	    }
	    
	    
	    public String getDestino() {
	        return destino;
	    }
	    

	    public void setDestino(String destino) {
	        this.destino = destino;
	    }
	    
	    
	    public String getCpf() {
	        return cpf;
	    }
	    

	    public void setCpf(String cpf) {
	        this.cpf = cpf;
	    }
	    
	    public float getPrecoTotal() {
	        return precoTotal;
	    }
	    

	    public void setPrecoTotal(float precoTotal) {
	        this.precoTotal = precoTotal;
	    }
}
