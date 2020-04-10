package model;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaCliente implements Printer {
	
	private ArrayList<Cliente> listaCliente;
	
	public ListaCliente() 
	{
		listaCliente = new ArrayList<Cliente>();
	}
	
	public void replaceCliente( Cliente spare) 
	{
		String key = spare.getCpf();
		int i=0;
		for( i=0;i<listaCliente.size();i++) 
		{
			if(listaCliente.get(i).getCpf().equals(key)) 
			{
				break;
			}
		}
		listaCliente.set(i, spare);
	}
	
	
	public void remove(String key) 
	{
		ArrayList<Cliente> temp = buscaCliente(key, 2);
		for(int i =0 ; i< temp.size();i++) 
		{
			listaCliente.remove(temp.get(i));
		}
	}
	
	public ArrayList<Cliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(ArrayList<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}

	public  ArrayList<Cliente> buscaCliente(String key, int type)
	{
		Iterator<Cliente> clienteIt = listaCliente.iterator();
		Cliente aux = new Cliente();
		ArrayList<Cliente> resultado = new ArrayList<Cliente>();
		//type é o tipo de dado
		switch(type) 
		{
		//Nome
		case 0:
			while(clienteIt.hasNext()) 
			{
				aux = clienteIt.next();
				if(aux.getNome().contains(key)) 
				{
					resultado.add(aux);
				}
			}
			
			break;
		//RG
		case 1:
			while(clienteIt.hasNext()) 
			{
				aux = clienteIt.next();
				if(aux.getRg().contains(key)) 
				{
					resultado.add(aux);
				}
			}
			break;
		//CPF
		case 2:
			while(clienteIt.hasNext()) 
			{
				aux = clienteIt.next();
				if(aux.getCpf().contains(key)) 
				{
					resultado.add(aux);
				}
			}
			break;
		}
		return resultado;
	}
	
	public boolean adicionaCliente(Cliente c) 
	{
		if(buscaCliente(c.getCpf(), 2).isEmpty()) 
		{
			listaCliente.add(c);
			return true;
		}
		return false;
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
