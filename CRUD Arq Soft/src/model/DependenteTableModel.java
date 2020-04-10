package model;

import javax.swing.table.AbstractTableModel;

public class DependenteTableModel extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] columnNames = {"Nome", "RG"};
	private String[][] data = new String[10][2];
	
	
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
	
	public void fillData( Pessoa p[]) 
	{
		int line = p.length;
		int i=0;
		int j=0;
		int pessoaIt = 0;
		while(pessoaIt<=line-1) 
		{
			Pessoa aux = new Pessoa();
			if(p[pessoaIt]!=null) 
			{
				aux = p[pessoaIt];
			}
			data[i][j] = aux.getNome();
			data[i][j+1] = aux.getRg();
			if(i+1<line) 
			{
				i++;
			}
		pessoaIt++;
		}
	}

}
