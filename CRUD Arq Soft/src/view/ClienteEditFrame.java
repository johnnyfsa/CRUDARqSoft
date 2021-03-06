package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import control.ClienteController;
import control.FrameController;
import control.DependenteController;
import sun.font.CreatedFontTracker;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import model.Cliente;


public class ClienteEditFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nome;
	private JTextField rg;
	private JTable dependenteTable;
	private Cliente auxCliente;
	private JFormattedTextField bdate ;
	private JFormattedTextField cpf;
	
	/**
	 * Create the frame.
	 */
	public ClienteEditFrame(String key) {
		ArrayList<Cliente> aux = ClienteController.getClientes().buscaCliente(key, 2);
		Cliente current = aux.get(0);
		DependenteController.setDependentes(current.getDependentes());
		DependenteController.getDependenteTable().fillData(current.getDependentes());
		
		
		setResizable(false);
		TableModel dtm = DependenteController.getDependenteTable();
		setTitle("Editar Cliente");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 540, 671);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		MaskFormatter bdate_format;
		MaskFormatter rg_format;
		MaskFormatter cpf_format;
		try {
			bdate_format = new MaskFormatter("##/##/####");
			rg_format = new MaskFormatter("########-##");
			cpf_format = new MaskFormatter("###.###.###-##");
			contentPane.setLayout(null);
			
			
			bdate = new JFormattedTextField(bdate_format);  
			bdate.setBounds(36, 102, 86, 20);
			bdate.setColumns(10);
			contentPane.add(bdate);
			bdate.setText(current.getData_nascimento());
			
			rg = new JFormattedTextField(rg_format);
			rg.setBounds(36, 148, 94, 20);
			contentPane.add(rg);
			rg.setColumns(11);
			rg.setText(current.getRg());
			
			cpf = new JFormattedTextField(cpf_format);
			cpf.setEditable(false);
			cpf.setBounds(36, 194, 118, 20);
			cpf.setColumns(14);
			contentPane.add(cpf);
			cpf.setText(current.getCpf());
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		JLabel lblNewLabel = new JLabel("Nome*");
		lblNewLabel.setBounds(36, 36, 483, 14);
		contentPane.add(lblNewLabel);
		
		
		nome = new JTextField();
		nome.setBounds(36, 56, 166, 20);
		contentPane.add(nome);
		nome.setColumns(20);
		nome.setText(current.getNome());
		
		JLabel lblNewLabel_1 = new JLabel("Data de Nascimento*");
		lblNewLabel_1.setBounds(36, 82, 483, 14);
		contentPane.add(lblNewLabel_1);
		
		
		JLabel lblNewLabel_2 = new JLabel("RG");
		lblNewLabel_2.setBounds(36, 128, 483, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(36, 174, 483, 14);
		contentPane.add(lblCpf);
		
		JPanel panel = new JPanel();
		panel.setBounds(36, 220, 483, 407);
		contentPane.add(panel);
		panel.setLayout(null);
		
		dependenteTable = new JTable(dtm);
		dependenteTable.setBounds(10, 55, 429, 229);
		panel.add(dependenteTable);
		
		JLabel lbdependentes = new JLabel("Dependentes");
		lbdependentes.setBounds(10, 23, 117, 21);
		panel.add(lbdependentes);
		
		JButton btnCadastrarNovoDependente = new JButton("Cadastrar Novo Dependente");
		btnCadastrarNovoDependente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameController.getDependenteFromEdit().setVisible(true);
			}
		});
		btnCadastrarNovoDependente.setBounds(10, 322, 195, 23);
		panel.add(btnCadastrarNovoDependente);
		
		JButton btnRemoverDependente = new JButton("Remover dependente");
		btnRemoverDependente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = dependenteTable.getSelectedRow(); // select a row
				String auxrg =(String)dependenteTable.getValueAt(row, 1);
				DependenteController.removeDependente(auxrg);
				FrameController.getEditar().getDependenteTable().repaint();
			}
		});
		btnRemoverDependente.setBounds(283, 322, 156, 23);
		panel.add(btnRemoverDependente);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameController.getEditar().setVisible(false);
				DependenteController.resetDependentes();
				FrameController.resetClienteForm();
				FrameController.getStart().setVisible(true);
				
			}
		});
		btnCancelar.setBounds(350, 373, 89, 23);
		panel.add(btnCancelar);
		
		JButton confirmbtn = new JButton("Confirmar");
		confirmbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String auxNome = nome.getText();
				String auxDataDeNascimento = bdate.getText().replaceAll("\\D", "");
				String auxcpf = cpf.getText().replaceAll("\\D", "");
				String auxRg = rg.getText().replaceAll("\\D", "");
				
				if(auxNome.isEmpty()|| auxDataDeNascimento.isEmpty()||auxcpf.isEmpty()) 
				{
					FrameController.error(0);
					FrameController.getErro().setVisible(true);
				}
				else 
				{
					auxDataDeNascimento = bdate.getText();
					Cliente c = new Cliente(auxNome, auxDataDeNascimento, auxcpf, auxRg);
					boolean val = ClienteController.getValidadorCliente().validar(c);
					//se estiver tudo v�lido
					if(val == true) 
					{
						System.out.println("cpf valido");
						c.setDependentes(DependenteController.getDependentes());
						ClienteController.getClientes().replaceCliente(c);
						ClienteController.salvaClientes();
						DependenteController.resetDependentes();
						FrameController.getEditar().dispose();
					}
					else
					{
						FrameController.error(1);
						FrameController.getErro().setVisible(true);
					}
				}
			}
		});
		confirmbtn.setBounds(10, 373, 117, 23);
		panel.add(confirmbtn);
		
		JLabel lblNewLabel_3 = new JLabel("* Campos Obrigat\u00F3rios ");
		lblNewLabel_3.setBounds(321, 200, 126, 14);
		contentPane.add(lblNewLabel_3);
		
		
		
		
	}
	public JTable getDependenteTable() 
	{
		return dependenteTable;
	}
}
