package interface_grafica;


import comparadores.OrdenaPorNome;
import dados.CadastroPessoas;
import dados.Pessoa;
import dao.PessoaDao;
import saida.Visao;
import validacao.Validacao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

@SuppressWarnings("serial")
public class MenuPesquisa extends JFrame {
    private TabelaCadastros tabela;
    private JScrollPane scrollPane;
    private JLabel lbPergunta;
    private JTextField textPergunta;
    private JButton btnPesquisa;
    private JLabel lbQuantidade;

    public MenuPesquisa(CadastroPessoas cadastroPessoas){
        setIconImage(Toolkit.getDefaultToolkit().getImage(MenuLista.class.getResource("/icones/icons8_google_web_search_32px.png")));
        setResizable(false);
        setTitle("Pesquisa");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(0, 0, 891, 575);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 48, 855, 474);

        lbPergunta = new JLabel("Digite o nome a ser pesquisado:");
        lbPergunta.setBounds(12, 10, 222, 26);
        getContentPane().add(lbPergunta);

        textPergunta = new JTextField();
        textPergunta.setColumns(10);
        textPergunta.setBounds(192, 10, 222, 26);
        getContentPane().add(textPergunta);

        lbQuantidade = new JLabel();
        lbQuantidade.setBounds(640, 10, 222, 26);
        getContentPane().add(lbQuantidade);

        tabela = new TabelaCadastros(cadastroPessoas);
        String[] col = {"Identificador", "Nome", "Situacao de saude", "Idade", "Gestante"};
        tabela.setModel(new DefaultTableModel(col, 0));
        tabela.alinhaTabela();

        btnPesquisa = new JButton("Pesquisar");
        btnPesquisa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnPesquisa.setBounds(424, 10, 113, 26);
        btnPesquisa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(Validacao.validaPesquisaNome(textPergunta.getText()) == 1){
                    tabela.setModel(preencheTabela(cadastroPessoas, textPergunta.getText().trim()));
                    tabela.alinhaTabela();
                    if(tabela.getRowCount() == 0){
                        Visao.mostraMensagem("Nenhuma pessoa encontrada com esse nome.");
                    }
                    lbQuantidade.setText("Quantidade de registros recuperados: " + tabela.getRowCount());
                }
            }
        });
        getContentPane().add(btnPesquisa);

        scrollPane.setViewportView(tabela);
        getContentPane().add(scrollPane);
    }

    DefaultTableModel preencheTabela(CadastroPessoas cadastroPessoas, String nome){
        cadastroPessoas.setRegistro(new PessoaDao().carregar());

        String[] col = {"Identificador", "Nome", "Situacao de saude", "Idade", "Gestante"};
        DefaultTableModel modeloTabela = new DefaultTableModel(col, 0);

        ArrayList<Pessoa> registro = cadastroPessoas.getRegistro();
        Collections.sort(registro, new OrdenaPorNome());

        for(Pessoa pessoa : registro){
            if(pessoa.getNome().contains(nome)){
                Object[] data = {pessoa.getNumero(), pessoa.getNome().toLowerCase(), pessoa.getSaudeExtenso(), pessoa.getStringIdade(), pessoa.getGestacaoString()};
                modeloTabela.addRow(data);
            }
        }

        return modeloTabela;
    }

}
