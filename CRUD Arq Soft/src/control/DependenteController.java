package control;

import model.ConcretePessoaValidator;
import model.DependenteTableModel;
import model.Pessoa;

public class DependenteController {
	
	private static Pessoa dependentes[] = new Pessoa[10];
	private static ConcretePessoaValidator validadorDependente = new ConcretePessoaValidator(); 
	private static DependenteTableModel dependenteTable = new DependenteTableModel();
	
	public static void resetDependentes() 
	{
		setDependentes(new Pessoa[10]);
		dependenteTable.fillData(dependentes);
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
		dependenteTable.fillData(dependentes);
	}
	
	public static void removeDependente(String rg ) 
	{
		for(int i=0;i<getDependentes().length;i++) 
		{
			if(getDependentes()[i]!=null) 
			{
				if(getDependentes()[i].getRg().equals(rg)) 
				{
					dependentes[i] = null;
				}
			}
			
		}
		dependenteTable.fillData(dependentes);
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

	public static DependenteTableModel getDependenteTable() {
		return dependenteTable;
	}

	public static void setDependenteTable(DependenteTableModel dependenteTable) {
		DependenteController.dependenteTable = dependenteTable;
	}
}
