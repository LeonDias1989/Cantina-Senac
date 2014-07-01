package br.com.senac.relatorios;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TelaRelatorioCliente extends JFrame {

	private JPanel contentPane;
	private String textoRelatorio;
	private JTextArea textArea;
	private JButton btnSair;

	public String getTextoRelatorio() {
		return textoRelatorio;
	}

	public TelaRelatorioCliente(String textoRelatorio) {

		this.textoRelatorio = textoRelatorio;

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 687, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(70, 33, 556, 354);
		contentPane.add(scrollPane);

		textArea = new JTextArea(textoRelatorio);
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);

		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				dispose();
			}
		});
		btnSair.setBounds(70, 398, 89, 23);
		contentPane.add(btnSair);
		setVisible(true);
		setResizable(false);
	}

	public static void main(String[] args) {
		new TelaRelatorioCliente(new String());
	}
}
