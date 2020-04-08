package control;

import model.ListaCliente;
import model.ClienteTableModel;
import model.ClienteValidator;

public class ClienteController {

	
	private static ListaCliente lista_de_clientes = new ListaCliente();
	private static ClienteTableModel ctm = new ClienteTableModel();
	private static ClienteValidator validadorCliente = new ClienteValidator();
	
	public static void carregaClientes() 
	{
		FileController.jsonRead(lista_de_clientes);
		ClienteController.fillTableModel();
	}
	
	public static void salvaClientes() 
	{
		FileController.jsonWrite(lista_de_clientes);
		ClienteController.fillTableModel();
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

	public static ClienteValidator getValidadorCliente() {
		return validadorCliente;
	}

	public static void setValidadorCliente(ClienteValidator cVal) {
		ClienteController.validadorCliente = cVal;
	}
	
}
