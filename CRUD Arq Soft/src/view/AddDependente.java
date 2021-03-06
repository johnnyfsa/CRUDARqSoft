package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import control.ClienteController;
import control.FrameController;
import control.DependenteController;
import model.Cliente;
import model.Pessoa;

import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddDependente extends JFrame {

	private JPanel contentPane;
	private JTextField nome;
	private JFormattedTextField bdate;
	private JFormattedTextField rg;
	private JFormattedTextField cpf;

	/**
	 * Create the frame.
	 */
	
	public AddDependente() {
		setResizable(false);
		setTitle("Cadastrar Dependente");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 535, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		MaskFormatter bdate_format;
		MaskFormatter rg_format;
		MaskFormatter cpf_format;
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(contentPane_1, BorderLayout.CENTER);
		
		try {
			bdate_format = new MaskFormatter("##/##/####");
			rg_format = new MaskFormatter("########-##");
			cpf_format = new MaskFormatter("###.###.###-##");
			bdate = new JFormattedTextField(bdate_format);
			bdate.setColumns(10);
			bdate.setBounds(36, 102, 86, 20);
			contentPane_1.add(bdate);
			
			rg = new JFormattedTextField(rg_format);
			rg.setColumns(11);
			rg.setBounds(36, 148, 94, 20);
			contentPane_1.add(rg);
			
			cpf = new JFormattedTextField(cpf_format);
			cpf.setColumns(14);
			cpf.setBounds(36, 194, 118, 20);
			contentPane_1.add(cpf);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel lblNewLabel = new JLabel("Nome*");
		lblNewLabel.setBounds(36, 36, 483, 14);
		contentPane_1.add(lblNewLabel);
		
		nome = new JTextField();
		nome.setColumns(20);
		nome.setBounds(36, 56, 166, 20);
		contentPane_1.add(nome);
		
		JLabel lblNewLabel_1 = new JLabel("Data de Nascimento*");
		lblNewLabel_1.setBounds(36, 82, 483, 14);
		contentPane_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("RG");
		lblNewLabel_2.setBounds(36, 128, 483, 14);
		contentPane_1.add(lblNewLabel_2);
		
		JLabel lblCpf = new JLabel("CPF*");
		lblCpf.setBounds(36, 174, 483, 14);
		contentPane_1.add(lblCpf);
		
		JLabel lblNewLabel_3 = new JLabel("* Campos Obrigat\u00F3rios ");
		lblNewLabel_3.setBounds(321, 200, 126, 14);
		contentPane_1.add(lblNewLabel_3);
		
		JButton cancelbtn = new JButton("cancelar");
		cancelbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameController.getDependenteForm().setVisible(false);
				FrameController.resetDependenteForm();
			}
		});
		cancelbtn.setBounds(336, 256, 89, 23);
		contentPane_1.add(cancelbtn);
		
		JButton confirmbtn = new JButton("confirmar");
		confirmbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String auxNome = nome.getText();
				String auxDataDeNascimento = bdate.getText();
				String auxcpf = cpf.getText().replaceAll("\\D", "");
				String auxRG = rg.getText().replaceAll("\\D", "");
				
				if(auxNome.isEmpty()|| auxDataDeNascimento.isEmpty()||auxRG.isEmpty()) 
				{
					FrameController.error(0);
					FrameController.getErro().setVisible(true);
				}
				else 
				{
					auxDataDeNascimento = bdate.getText();
					Pessoa p = new Pessoa(auxNome, auxDataDeNascimento, auxcpf, auxRG);
					boolean val = DependenteController.getValidadorDependente().validar(p);
					//se estiver tudo v�lido
					if(val == true) 
					{
						System.out.println("cpf valido");
						DependenteController.adicionaDependente(p);
						FrameController.getClienteForm().getDpt().repaint();;
						FrameController.getDependenteForm().dispose();
					}
					//sen�o
					else
					{
						if(DependenteController.getValidadorDependente().isMenor_de_21()==false) 
						{
							FrameController.error(3);
							FrameController.getErro().setVisible(true);
						}
						else 
						{
							FrameController.error(1);
							FrameController.getErro().setVisible(true);
						}
					}
				}
			}
		});
		confirmbtn.setBounds(33, 256, 89, 23);
		contentPane_1.add(confirmbtn);
	}
}
