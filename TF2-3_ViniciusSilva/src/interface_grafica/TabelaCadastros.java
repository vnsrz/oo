package interface_grafica;

import comparadores.OrdenaPorId;
import dados.CadastroPessoas;
import dados.Pessoa;
import dao.PessoaDao;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

@SuppressWarnings("serial")
public class TabelaCadastros extends JTable {

    public TabelaCadastros(CadastroPessoas cadastroPessoas) {
        setFocusable(false);
        setShowGrid(true);
        setGridColor(Color.LIGHT_GRAY);

        getTableHeader().setReorderingAllowed(false);
    }

    DefaultTableModel preencheTabela(CadastroPessoas cadastroPessoas) {
        cadastroPessoas.setRegistro(new PessoaDao().carregar());

        String[] col = {"Identificador", "Nome", "Situacao de saude", "Idade", "Gestante"};
        DefaultTableModel modeloTabela = new DefaultTableModel(col, 0);

        ArrayList<Pessoa> registro = cadastroPessoas.getRegistro();

        Collections.sort(registro, new OrdenaPorId());

        for (Pessoa pessoa : registro) {
            Object[] data = {pessoa.getNumero(), pessoa.getNome().toLowerCase(), pessoa.getSaudeExtenso(), pessoa.getStringIdade(), pessoa.getGestacaoString()};
            modeloTabela.addRow(data);
        }

        return modeloTabela;
    }

    void alinhaTabela(){
        this.getColumnModel().getColumn(1).setPreferredWidth(222);
        this.getColumnModel().getColumn(2).setPreferredWidth(165);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for(int i=0; i<4 ;i++){
            this.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    public boolean isCellEditable(int row, int column) {
        return false;
    }

}
