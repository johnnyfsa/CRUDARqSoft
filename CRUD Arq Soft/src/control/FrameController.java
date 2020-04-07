package control;
import view.*;


public class FrameController {

	private static OverView start = new OverView();
	private static Cadastro clienteForm = new Cadastro();
	
	
	
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


	
	
}
