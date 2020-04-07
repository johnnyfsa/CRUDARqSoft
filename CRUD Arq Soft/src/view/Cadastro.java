package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import control.FrameController;
import sun.font.CreatedFontTracker;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cadastro extends JFrame {

	private JPanel contentPane;
	private JTextField nome;
	private JTextField rg;
	private JTable table;


	/**
	 * Create the frame.
	 */
	public Cadastro() {
		setTitle("Cadastrar Cliente");
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
			
			
			JFormattedTextField data = new JFormattedTextField(bdate_format);  
			data.setBounds(36, 102, 86, 20);
			data.setColumns(10);
			contentPane.add(data);
			
			rg = new JFormattedTextField(rg_format);
			rg.setBounds(36, 148, 94, 20);
			contentPane.add(rg);
			rg.setColumns(11);
			
			JFormattedTextField cpf = new JFormattedTextField(cpf_format);
			cpf.setBounds(36, 194, 118, 20);
			cpf.setColumns(14);
			contentPane.add(cpf);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(36, 36, 483, 14);
		contentPane.add(lblNewLabel);
		
		nome = new JTextField();
		nome.setBounds(36, 56, 166, 20);
		contentPane.add(nome);
		nome.setColumns(20);
		
		JLabel lblNewLabel_1 = new JLabel("Data de Nascimento");
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
		
		table = new JTable();
		table.setBounds(10, 55, 429, 229);
		panel.add(table);
		
		JLabel lbdependentes = new JLabel("Dependentes");
		lbdependentes.setBounds(10, 23, 117, 21);
		panel.add(lbdependentes);
		
		JButton btnCadastrarNovoDependente = new JButton("Cadastrar Novo Dependente");
		btnCadastrarNovoDependente.setBounds(10, 322, 195, 23);
		panel.add(btnCadastrarNovoDependente);
		
		JButton btnRemoverDependente = new JButton("Remover dependente");
		btnRemoverDependente.setBounds(283, 322, 156, 23);
		panel.add(btnRemoverDependente);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameController.getClienteForm().setVisible(false);
				FrameController.resetClienteForm();
				FrameController.getStart().setVisible(true);
				
			}
		});
		btnCancelar.setBounds(350, 373, 89, 23);
		panel.add(btnCancelar);
		
		
		
		
	}
}
