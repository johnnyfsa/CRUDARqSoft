package control;
import model.*;
import java.io.IOException;


public class Main {

	public static void main(String[] args) {
		ListaCliente list = new ListaCliente();
		try {
			FileController.jsonRead(list);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		list.print();
	}

}
