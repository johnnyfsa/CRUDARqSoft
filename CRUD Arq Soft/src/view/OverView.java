package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import control.ClienteController;
import control.FrameController;

import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import control.ClienteController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class OverView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField searchTextField;
	private final ButtonGroup buttonGroup = new ButtonGroup();


	/**
	 * Create the frame.
	 */
	public JTable getTable() 
	{
		return table;
	}
	
	public OverView() {
		setResizable(false);
		setTitle("CRUD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		TableModel ctm = ClienteController.getClienteTableModel();
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setBounds(15, 392, 130, 23);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					FrameController.resetClienteForm();
					FrameController.getClienteForm().setVisible(true);
					FrameController.getStart().setVisible(false);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		JButton btnNewButton_1 = new JButton("Editar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					int row = table.getSelectedRow(); // select a row
					int column = table.getSelectedColumn(); // select a column
					FrameController.setEditar(new ClienteEditFrame((String)table.getValueAt(row, 1)));
					FrameController.getEditar().setVisible(true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Selecione Alguma Linha da Tabela");
					e.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(468, 392, 130, 23);
		
		JButton btnNewButton_2 = new JButton("Remover");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int row = table.getSelectedRow(); // select a row
					String auxCpf =(String)table.getValueAt(row, 1);
					ClienteController.getClientes().remove(auxCpf);
					ClienteController.salvaClientes();
					table.repaint();
					
				} 
				catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Selecione Alguma Linha da Tabela");
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(468, 473, 130, 23);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 144, 583, 214);
		contentPane.setLayout(null);
		contentPane.add(btnNewButton_2);
		contentPane.add(btnNewButton);
		contentPane.add(btnNewButton_1);
		contentPane.add(scrollPane);
		
		//table = new JTable();
		table = new JTable(ctm);
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER)
				{
					int row = table.getSelectedRow(); // select a row
		            int column = table.getSelectedColumn(); // select a column
		            FrameController.setClienteView(new ClienteFrame((String) table.getValueAt(row, 1)));
		            FrameController.getClienteView().setVisible(true);
		            //JOptionPane.showMessageDialog(null, table.getValueAt(row, 1)); // get the value of a row and column.
				}
			}
		});
		
		scrollPane.setViewportView(table);
		 table.addMouseListener(new MouseAdapter() {
	         public void mouseClicked(MouseEvent me) {
	            if (me.getClickCount() == 2) {     // to detect doble click events
	               JTable target = (JTable)me.getSource();
	               int row = target.getSelectedRow(); // select a row
	               int column = target.getSelectedColumn(); // select a column
	               FrameController.setClienteView(new ClienteFrame((String) table.getValueAt(row, 1)));
		           FrameController.getClienteView().setVisible(true);
	              //JOptionPane.showMessageDialog(null, table.getValueAt(row, 1)); // get the value of a row and column.
	            }
	         }
	      });
		
		searchTextField = new JTextField();
		searchTextField.setBounds(15, 69, 583, 20);
		contentPane.add(searchTextField);
		searchTextField.setColumns(10);
		
		JLabel searchLbl = new JLabel("Procurar por:");
		searchLbl.setBounds(10, 40, 101, 23);
		contentPane.add(searchLbl);
		
		JRadioButton rdbtName = new JRadioButton("Nome");
		rdbtName.setSelected(true);
		buttonGroup.add(rdbtName);
		rdbtName.setBounds(213, 40, 109, 23);
		contentPane.add(rdbtName);
		
		JRadioButton rdbtRg = new JRadioButton("RG");
		buttonGroup.add(rdbtRg);
		rdbtRg.setBounds(324, 40, 109, 23);
		contentPane.add(rdbtRg);
		
		JRadioButton rdbtCpf = new JRadioButton("CPF");
		buttonGroup.add(rdbtCpf);
		rdbtCpf.setBounds(435, 40, 109, 23);
		contentPane.add(rdbtCpf);
		
		JButton confirmBtn = new JButton("ok");
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int type = 0;
				String key = searchTextField.getText();
				if(rdbtName.isSelected()) 
				{
					type =0;
				}
				else if(rdbtRg.isSelected()) 
				{
					type=1;
				}
				else if(rdbtCpf.isSelected()) 
				{
					type=2;
				}
				ClienteController.busca(key, type);
				table.repaint();
			}
		});
		confirmBtn.setBounds(509, 100, 89, 23);
		contentPane.add(confirmBtn);
	}
}
