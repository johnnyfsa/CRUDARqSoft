package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.text.MaskFormatter;

import control.ClienteController;
import control.DependenteController;
import model.Cliente;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClienteFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nomeTextField;
	private JTable table;
	private MaskFormatter bdate_format;
	private MaskFormatter rg_format;
	private MaskFormatter cpf_format;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public ClienteFrame(String key) {
		setResizable(false);
		setTitle("Visualizar Cliente");
		
		ArrayList<Cliente> aux = ClienteController.getClientes().buscaCliente(key, 2);
		Cliente current = aux.get(0);
		DependenteController.getDependenteTable().fillData(current.getDependentes());
		
		TableModel dtm = DependenteController.getDependenteTable();
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 562, 698);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(contentPane_1, BorderLayout.CENTER);
		
		try {
			bdate_format = new MaskFormatter("##/##/####");
			rg_format = new MaskFormatter("########-##");
			cpf_format = new MaskFormatter("###.###.###-##");
			
			JFormattedTextField bdate = new JFormattedTextField(bdate_format);
			bdate.setEditable(false);
			bdate.setColumns(10);
			bdate.setBounds(36, 102, 86, 20);
			contentPane_1.add(bdate);
			bdate.setText(current.getData_nascimento());
			
			
			JFormattedTextField rg = new JFormattedTextField(rg_format );
			rg.setEditable(false);
			rg.setColumns(11);
			rg.setBounds(36, 148, 94, 20);
			contentPane_1.add(rg);
			rg.setText(current.getRg());
			
			JFormattedTextField cpf = new JFormattedTextField(cpf_format );
			cpf.setEditable(false);
			cpf.setColumns(14);
			cpf.setBounds(36, 194, 118, 20);
			contentPane_1.add(cpf);
			cpf.setText(current.getCpf());
			
			JLabel lblNome = new JLabel("Nome");
			lblNome.setBounds(36, 36, 483, 14);
			contentPane_1.add(lblNome);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		nomeTextField = new JTextField();
		nomeTextField.setEditable(false);
		nomeTextField.setColumns(20);
		nomeTextField.setBounds(36, 56, 166, 20);
		contentPane_1.add(nomeTextField);
		nomeTextField.setText(current.getNome());
		
		JLabel lblNewLabel_1 = new JLabel("Data de Nascimento");
		lblNewLabel_1.setBounds(36, 82, 483, 14);
		contentPane_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("RG");
		lblNewLabel_2.setBounds(36, 128, 483, 14);
		contentPane_1.add(lblNewLabel_2);
		
		JLabel lblCpf_1 = new JLabel("CPF");
		lblCpf_1.setBounds(36, 174, 483, 14);
		contentPane_1.add(lblCpf_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(36, 220, 483, 407);
		contentPane_1.add(panel);
		
		table = new JTable(dtm);
		table.setBounds(10, 55, 429, 229);
		panel.add(table);
		
		JLabel lbdependentes = new JLabel("Dependentes");
		lbdependentes.setBounds(10, 23, 117, 21);
		panel.add(lbdependentes);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnVoltar.setBounds(350, 373, 89, 23);
		panel.add(btnVoltar);
	}

}
