package br.com.crud.model;

public class Agencia {

	  private String cnpj, unidade, nomeFantasia, endereco, telefone, email;

	  
	    

	    public String getCnpj() {
	        return cnpj;
	    }
	    

	    public void setCnpj(String cnpj) {
	        this.cnpj = cnpj;
	    }
	    
	    public String getUnidade() {
	        return unidade;
	    }
	    

	    public void setUnidade(String unidade) {
	        this.unidade = unidade;
	    }
	   
	    public String getNomeFantasia() {
	        return nomeFantasia;
	    }
	    

	    public void setNomeFantasia(String nomeFantasia) {
	        this.nomeFantasia = nomeFantasia;
	    }
	    
	    
	    public String getEndereco() {
	        return endereco;
	    }
	    

	    public void setEndereco(String endereco) {
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
	    
	 
	    public boolean contratar() {

	        return false;
	    }
	    

	    public boolean demitir() {

	        return false;
	    }

}
