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

import sun.font.CreatedFontTracker;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class Cadastro extends JFrame {

	private JPanel contentPane;
	private JTextField nome;
	private JTextField rg;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Cadastro() {
		setTitle("Cadastrar Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 671);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		MaskFormatter bdate_format;
		MaskFormatter rg_format;
		MaskFormatter cpf_format;
		try {
			bdate_format = new MaskFormatter("##/##/####");
			rg_format = new MaskFormatter("########-##");
			cpf_format = new MaskFormatter("###.###.###-##");
			
			
			JFormattedTextField data = new JFormattedTextField(bdate_format);  
			data.setColumns(10);
			contentPane.add(data, "4, 10, left, default");
			
			rg = new JFormattedTextField(rg_format);
			contentPane.add(rg, "4, 14, left, default");
			rg.setColumns(11);
			
			JFormattedTextField cpf = new JFormattedTextField(cpf_format);
			cpf.setColumns(14);
			contentPane.add(cpf, "4, 18, left, default");
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		JLabel lblNewLabel = new JLabel("Nome");
		contentPane.add(lblNewLabel, "4, 4");
		
		nome = new JTextField();
		contentPane.add(nome, "4, 6, left, default");
		nome.setColumns(20);
		
		JLabel lblNewLabel_1 = new JLabel("Data de Nascimento");
		contentPane.add(lblNewLabel_1, "4, 8");
		
		
		JLabel lblNewLabel_2 = new JLabel("RG");
		contentPane.add(lblNewLabel_2, "4, 12");
		
		JLabel lblCpf = new JLabel("CPF");
		contentPane.add(lblCpf, "4, 16");
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "4, 20, fill, fill");
		panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 55, 429, 229);
		panel.add(table);
		
		JLabel lbdependentes = new JLabel("Dependentes");
		lbdependentes.setBounds(10, 23, 117, 21);
		panel.add(lbdependentes);
		
		JButton btnCadastrarNovoDependente = new JButton("Cadastrar Novo Dependente");
		btnCadastrarNovoDependente.setBounds(10, 322, 177, 23);
		panel.add(btnCadastrarNovoDependente);
		
		JButton btnRemoverDependente = new JButton("Remover dependente");
		btnRemoverDependente.setBounds(283, 322, 156, 23);
		panel.add(btnRemoverDependente);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(350, 373, 89, 23);
		panel.add(btnCancelar);
		
		
		
		
	}
}
