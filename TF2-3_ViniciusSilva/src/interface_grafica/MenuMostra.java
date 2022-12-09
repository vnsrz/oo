package interface_grafica;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import dados.CadastroPessoas;
import saida.Visao;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

@SuppressWarnings("serial")
public class MenuMostra extends JFrame {
	private JPanel contentPane;
	private JTextField textPesquisa;
	private JLabel lbPesquisa;
	private JButton btnPesquisar;

	public MenuMostra(CadastroPessoas cadastroPessoas) {
		setTitle("Mostra");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuMostra.class.getResource("/icones/icons8_workspace_32px_1.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 128);
		setLocationRelativeTo(null);
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textPesquisa = new JTextField();
		textPesquisa.setBounds(10, 48, 271, 26);
		contentPane.add(textPesquisa);
		textPesquisa.setColumns(10);
		
		lbPesquisa = new JLabel("Digite o ID da pessoa a ser pesquisada:");
		lbPesquisa.setBounds(10, 11, 222, 26);
		contentPane.add(lbPesquisa);

		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Visao.mostraPessoa(cadastroPessoas, textPesquisa.getText());
			}
		});
		btnPesquisar.setBounds(311, 48, 113, 26);
		contentPane.add(btnPesquisar);
	}
}
