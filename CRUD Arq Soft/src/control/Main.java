package control;
import model.*;
import view.*;
import java.io.IOException;


public class Main {

	public static void main(String[] args) {
		
		
		ClienteController.carregaClientes();
		ClienteController.fillTableModel();
		OverView Frame = new OverView();
		Frame.setVisible(true);
	}

}
