package control;

import model.ListaCliente;

public class ClienteController {

	
	private static ListaCliente lista_de_clientes = new ListaCliente();
	
	public static void carregaClientes() 
	{
		FileController.jsonRead(lista_de_clientes);
	}
	
	public static void imprimeClientes() 
	{
		lista_de_clientes.print();
	}
}
