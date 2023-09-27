package br.com.crud.model;

public class Departamento extends Agencia{

	   public int codDepartamento;
	   private String nomeDepartamento,cnpj;
	    
	    
	    public int getCodDepartamento() {
	        return codDepartamento;
	    }
	    

	    public void setCodDepartamento(int codDepartamento) {
	        this.codDepartamento = codDepartamento;
	    }
	    

	    public String getNomeDepartamento() {
	        return nomeDepartamento;
	    }
	    

	    public void setNomeDepartamento(String nomeDepartamento) {
	        this.nomeDepartamento = nomeDepartamento;
	    }
	    
	    
	    // INFORMAÇÕES DE AGENCIA
	    public String getCnpj() {
	    	return cnpj;
	    }
	    
	    public void setCnpj(String cnpj) {
	    	this.cnpj = cnpj;
	    }
}
