package interface_grafica;

import java.awt.Color;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import comparadores.OrdenaPorId;
import dados.CadastroPessoas;
import dados.Pessoa;


@SuppressWarnings("serial")
public class MenuLista extends JFrame {
	private JScrollPane scrollPane;
	private TabelaCadastros tabela;

	public MenuLista(CadastroPessoas cadastroPessoas) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuLista.class.getResource("/icones/icons8_align_text_left_32px_1.png")));
		setResizable(false);
		setTitle("Lista");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 891, 535);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 855, 474);

		tabela = new TabelaCadastros(cadastroPessoas);
		tabela.setModel(tabela.preencheTabela(cadastroPessoas));
		tabela.alinhaTabela();

		scrollPane.setViewportView(tabela);
		getContentPane().add(scrollPane);
	}
	
}

