package control;
import view.*;


public class FrameController {

	private static OverView start = new OverView();
	private static Cadastro clienteForm = new Cadastro();
	private static ErrorFrame erro;
	
	
	public static void error(int code) 
	{
		setErro(new ErrorFrame(code));
		/*Códigos de erro:
		 * 0: Campo Obrigatorio vazio
		 * 1: CPF invalido*/
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


	
	
}
