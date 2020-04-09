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
		fillDependenteTable();
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
		fillDependenteTable();
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

	public static DependenteTableModel getDependenteTable() {
		return dependenteTable;
	}

	public static void setDependenteTable(DependenteTableModel dependenteTable) {
		DependenteController.dependenteTable = dependenteTable;
	}
	public static void fillDependenteTable() 
	{
		dependenteTable.fillData(dependentes);
	}
}
