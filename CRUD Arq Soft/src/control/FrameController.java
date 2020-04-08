package control;
import view.*;


public class FrameController {

	private static OverView start = new OverView();
	private static Cadastro clienteForm = new Cadastro();
	private static ErrorFrame erro;
	private static AddDependente dependenteForm = new AddDependente();
	
	
	public static void error(int code) 
	{
		setErro(new ErrorFrame(code));
		/*Códigos de erro:
		 * 0: Campo Obrigatorio vazio
		 * 1: CPF invalido*/
	}
	
	
	public static void resetDependenteForm() 
	{
		dependenteForm = new AddDependente();
	}
	
	public static void resetStartFrame() 
	{
		start = new OverView();
	}
	
	public static void resetClienteForm() 
	{
		clienteForm = new Cadastro();
	}
	
	public static OverView getStart() {
		return start;
	}


	public static Cadastro getClienteForm() {
		return clienteForm;
	}

	public static ErrorFrame getErro() {
		return erro;
	}

	public static void setErro(ErrorFrame erro) {
		FrameController.erro = erro;
	}

	public static AddDependente getDependenteForm() {
		return dependenteForm;
	}

	public static void setDependenteForm(AddDependente adicionaDependente) {
		FrameController.dependenteForm = adicionaDependente;
	}


	
	
}
