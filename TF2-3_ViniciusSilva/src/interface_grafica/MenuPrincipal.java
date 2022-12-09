package interface_grafica;

import javax.swing.*;

import dados.CadastroPessoas;

import dao.PessoaDao;
import saida.Visao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Cursor;

@SuppressWarnings("serial")
public class MenuPrincipal extends JFrame implements ActionListener{
	private JButton botaoNovo, botaoLista, botaoMostra, botaoPesquisa, botaoSair;
	private CadastroPessoas cadastroPessoas =  new CadastroPessoas(new PessoaDao().carregar());
	
	public MenuPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/icones/icons8_google_code_32px_2.png")));
		this.setTitle("Menu");
		setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(0, 0, 356, 436);
		this.setLocationRelativeTo(null);
		
		getContentPane().setLayout(null);
		
		botaoNovo = new JButton("Novo");
		botaoNovo.setDefaultCapable(false);
		botaoNovo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botaoNovo.setPressedIcon(new ImageIcon(MenuPrincipal.class.getResource("/icones/icons8_hospital_32px_3.png")));
		botaoNovo.setHorizontalAlignment(SwingConstants.LEFT);
		botaoNovo.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icones/icons8_hospital_32px_1.png")));
		botaoNovo.setIconTextGap(98);
		botaoNovo.setBounds(10, 11, 323, 66);
		botaoNovo.addActionListener(this);
		getContentPane().add(botaoNovo);
		
		botaoLista = new JButton("Lista");
		botaoLista.setPressedIcon(new ImageIcon(MenuPrincipal.class.getResource("/icones/icons8_align_text_left_32px.png")));
		botaoLista.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botaoLista.setDefaultCapable(false);
		botaoLista.setHorizontalAlignment(SwingConstants.LEFT);
		botaoLista.setIconTextGap(101);
		botaoLista.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icones/icons8_align_text_left_32px_1.png")));
		botaoLista.setBounds(10, 88, 323, 66);
		botaoLista.addActionListener(this);
		getContentPane().add(botaoLista);
		
		botaoMostra = new JButton("Mostra");
		botaoMostra.setSelectedIcon(new ImageIcon(MenuPrincipal.class.getResource("/icones/icons8_workspace_32px.png")));
		botaoMostra.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botaoMostra.setDefaultCapable(false);
		botaoMostra.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icones/icons8_workspace_32px_1.png")));
		botaoMostra.setIconTextGap(95);
		botaoMostra.setHorizontalAlignment(SwingConstants.LEFT);
		botaoMostra.setBounds(10, 165, 323, 66);
		botaoMostra.addActionListener(this);
		getContentPane().add(botaoMostra);
		
		botaoPesquisa = new JButton("Pesquisa");
		botaoPesquisa.setPressedIcon(new ImageIcon(MenuPrincipal.class.getResource("/icones/icons8_google_web_search_32px_1.png")));
		botaoPesquisa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botaoPesquisa.setDefaultCapable(false);
		botaoPesquisa.setHorizontalAlignment(SwingConstants.LEFT);
		botaoPesquisa.setIconTextGap(91);
		botaoPesquisa.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icones/icons8_google_web_search_32px.png")));
		botaoPesquisa.setBounds(10, 242, 323, 66);
		botaoPesquisa.addActionListener(this);
		getContentPane().add(botaoPesquisa);
		
		botaoSair = new JButton("Sair");
		botaoSair.setPressedIcon(new ImageIcon(MenuPrincipal.class.getResource("/icones/icons8_cancel_32px_1.png")));
		botaoSair.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botaoSair.setDefaultCapable(false);
		botaoSair.setIconTextGap(104);
		botaoSair.setHorizontalAlignment(SwingConstants.LEFT);
		botaoSair.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icones/icons8_cancel_32px.png")));
		botaoSair.addActionListener(this);
		botaoSair.setBounds(10, 319, 323, 66);
		getContentPane().add(botaoSair);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton botao = (JButton) e.getSource();
		if(botao == botaoNovo) {
			JFrame frame = new MenuCadastros(cadastroPessoas);
			frame.setVisible(true);
		}
		if(botao == botaoSair) {
			Visao.mostraDados(cadastroPessoas);
			System.exit(0);
		}
		if(botao == botaoLista) {
			JFrame frame = new MenuLista(cadastroPessoas);
			frame.setVisible(true);
		}
		if(botao == botaoMostra) {
			JFrame frame = new MenuMostra(cadastroPessoas);
			frame.setVisible(true);
		}
		if(botao == botaoPesquisa) {
			JFrame frame = new MenuPesquisa(cadastroPessoas);
			frame.setVisible(true);
		}

	}


}
