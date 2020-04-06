package model;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.table.AbstractTableModel;

public class ClienteTableModel extends AbstractTableModel {
	
	private String[] columnNames = {"Nome", "CPF"};
	private String[][] data;
	
	
	public String getColumnName(int col) 
	{
		return columnNames[col];
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.length;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return data[arg0][arg1];
	}
	
	public void fillData( ArrayList<Cliente> c) 
	{
		int line = c.size();
		data = new String[line][2];
		Iterator<Cliente> clienteIterator = c.iterator();
		int i=0;
		int j=0;
		while(clienteIterator.hasNext()) 
		{
			Cliente aux = clienteIterator.next();
			data[i][j] = aux.getNome();
			data[i][j+1] = aux.getCpf();
			if(i+1<line) 
			{
				i++;
			}
			
		}
	}

}
