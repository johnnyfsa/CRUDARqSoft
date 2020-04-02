package model;

public class Cliente extends Pessoa {
	
	private  Pessoa[] dependentes;
	private int ClienteFlag;

	
	
	public Cliente() 
	{
		this.setClienteFlag(1);
		this.setCpf("");
		this.setData_nascimento("");
		this.setDependentes(new Pessoa[10]);
		this.setNome("");
		this.setRg("");
	}
	
	public Cliente( String nome, String data_nascimento,String cpf,String rg) 
	{
		this.setClienteFlag(1);
		this.setCpf(cpf);
		this.setData_nascimento(data_nascimento);
		this.setDependentes(new Pessoa[10]);
		this.setNome(nome);
		this.setRg(rg);
	}
	
	public Pessoa[] getDependentes() {
		return dependentes;
	}

	public void setDependentes(Pessoa[] dependentes) {
		this.dependentes = dependentes;
	}

	public int getClienteFlag() {
		return ClienteFlag;
	}

	public void setClienteFlag(int clienteFlag) {
		ClienteFlag = clienteFlag;
	} 

}
