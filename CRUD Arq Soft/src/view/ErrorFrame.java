package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.FrameController;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ErrorFrame extends JFrame {

	private JPanel contentPane;
	JLabel errorMsg; 

	/**
	 * Create the frame.
	 * 
	 */
	public ErrorFrame(int code) {
		
		switch (code) 
		{
		case 0:
			setTitle("Erro 0");
			errorMsg = new JLabel("Erro: Campo Obrigatório Vazio");
			break;
		case 1:
			setTitle("Erro 1");
			errorMsg = new JLabel("Erro: : CPF inválido");
			break;
		}	
		//setTitle("Erro 0");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		//errorMsg = new JLabel("Erro: CPF inválido");
		JButton confirmBtn = new JButton("ok");
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrameController.getErro().dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(182)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(confirmBtn)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(errorMsg, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(196))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(94)
					.addComponent(errorMsg)
					.addGap(26)
					.addComponent(confirmBtn)
					.addContainerGap(94, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
