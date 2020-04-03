package model;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaCliente implements Printer {
	
	private ArrayList<Cliente> listaCliente;
	
	public ListaCliente() 
	{
		listaCliente = new ArrayList<Cliente>();
	}

	public ArrayList<Cliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(ArrayList<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		Iterator<Cliente> ClienteIterator = listaCliente.iterator();
		while(ClienteIterator.hasNext()) 
		{
			Cliente c = new Cliente();
			c = ClienteIterator.next();
			System.out.println("CLIENTE:"+c.getClienteFlag()+", CPF:"+c.getCpf()+",DATA DE NASCIMENTO:"+c.getData_nascimento()
			+",NOME:"+c.getNome()+",RG:"+c.getRg());
			System.out.println("DEPENDENTES:\n");
			for(int i=0; i<c.getDependentes().length;i++) 
			{
				Pessoa p = new Pessoa();
				if(c.getDependentes()[i]!=null) 
				{
					p = c.getDependentes()[i];
					System.out.println("CPF:"+p.getCpf()+",DATA DE NASCIMENTO:"+p.getData_nascimento()
					+",NOME:"+p.getNome()+",RG:"+p.getRg());
				}
				
			}
		}
		
	}

}
