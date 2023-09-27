package br.com.crud.model;

import java.util.Date;
public class Pedido extends Passagem {

	
    private int idPedido, codDepartamento;
    private Date dataPedido;
    private String pagamento,cpfCli, statusPedido;
    private float precoTotal;
    
  
    public int getIdPedido() {
        return idPedido;
    }
    

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    
    public String getCpfCli() {
        return cpfCli;
    }
    

    public void setCpfCli(String cpfCli) {
        this.cpfCli = cpfCli;
    }
    
    
    public int getCodDepartamento() {
    	return  codDepartamento;
    }
    
    public void setCodDepartamento(int  codDepartamento) {
    	this. codDepartamento =  codDepartamento;
    }
    

    public Date getDataPedido() {
        return dataPedido;
    }
    

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }
    

    public String getPagamento() {
        return pagamento;
    }
    
    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }
    
      
    public String getStatusPedido() {
    	return statusPedido;
    }
    
    public void setStatusPedido(String statusPedido) {
    	this.statusPedido = statusPedido;
    }
    

    public float getPrecoTotal() {
        return precoTotal;
    }
    

    public void setPrecoTotal(float precoTotal) {
        this.precoTotal = precoTotal;
    }
    
}
