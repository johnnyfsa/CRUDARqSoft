package control;

import model.ConcretePessoaValidator;
import model.Pessoa;

public class DependenteController {
	
	private static Pessoa dependentes[] = new Pessoa[10];
	private static ConcretePessoaValidator validadorDependente = new ConcretePessoaValidator(); 
	
	public static void resetDependentes() 
	{
		setDependentes(new Pessoa[10]);
	}
	
	public static void adicionaDependente(Pessoa p) 
	{
		for(int i=0;i<getDependentes().length;i++) 
		{
			if(getDependentes()[i]==null) 
			{
				getDependentes()[i] = p;
				break;
			}
		}
	}
	
	public static void removeDependente() 
	{
		
	}

	
	public static ConcretePessoaValidator getValidadorDependente() {
		return validadorDependente;
	}

	public static void setValidadorDependente(ConcretePessoaValidator validadorDependente) {
		DependenteController.validadorDependente = validadorDependente;
	}

	public static Pessoa[] getDependentes() {
		return dependentes;
	}

	public static void setDependentes(Pessoa dependentes[]) {
		DependenteController.dependentes = dependentes;
	}
}
