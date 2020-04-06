package control;

import model.ListaCliente;
import model.ClienteTableModel;

public class ClienteController {

	
	private static ListaCliente lista_de_clientes = new ListaCliente();
	private static ClienteTableModel ctm = new ClienteTableModel();
	
	public static void carregaClientes() 
	{
		FileController.jsonRead(lista_de_clientes);
	}
	
	public static void fillTableModel(  ) 
	{
		ctm.fillData(lista_de_clientes.getListaCliente());
	}
	
	public static void imprimeClientes() 
	{
		lista_de_clientes.print();
	}
	
	public static ListaCliente getClientes() 
	{
		return lista_de_clientes;
	}
	public static ClienteTableModel getClienteTableModel() 
	{
		return ctm;
	}
	
}
