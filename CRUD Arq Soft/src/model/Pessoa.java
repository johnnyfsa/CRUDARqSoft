package model;

public class Pessoa {
	private String nome;
	private String data_nascimento;
	private String cpf;
	private String rg;
	
	
	
	
	public Pessoa() 
	{
		this.setCpf("");
		this.setData_nascimento("");
		this.setNome("");
		this.setRg("");
	}
	
	
	public Pessoa( String nome, String data_nascimento,String cpf,String rg) 
	{
		this.setCpf(cpf);
		this.setData_nascimento(data_nascimento);
		this.setNome(nome);
		this.setRg(rg);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getData_nascimento() {
		return data_nascimento;
	}
	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}

}
