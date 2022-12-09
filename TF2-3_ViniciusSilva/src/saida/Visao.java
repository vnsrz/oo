package saida;

import dados.Pessoa;
import dao.PessoaDao;
import validacao.Validacao;
import dados.CadastroPessoas;

import javax.swing.*;

public class Visao {
    public static void limpaTela(int n){
        for(int i=0; i<n ; i++ ){
            System.out.println();
        }
    }

    public static void mostraErro(String mensagem) {
    	JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public static int mostraConfirmacao(String mensagem) {
        return JOptionPane.showConfirmDialog(null, mensagem, "Pergunta", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
    }
    
    public static void mostraMensagem(String mensagem) {
    	JOptionPane.showMessageDialog(null, mensagem, "Informação", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void mostraDadosPessoa(String pessoa) {
    	JOptionPane.showMessageDialog(null, pessoa, "Dados", JOptionPane.PLAIN_MESSAGE);
    }	
    
    public static void mostraDados(CadastroPessoas cadastroPessoas){
    	String espacos = "                    ";
    	limpaTela(5);
        System.out.println(espacos + cadastroPessoas.quantidadeContaminacoes('C') + " = CONTAMINADOS CURADOS");
        System.out.println(espacos + cadastroPessoas.quantidadeContaminacoes('T') + " = CONTAMINADOS EM TRATAMENTO");
        System.out.println(espacos + cadastroPessoas.quantidadeContaminacoes('F') + " = CONTAMINADOS FALECIDOS");
        System.out.println(espacos + cadastroPessoas.quantidadeSaudaveis('M') + " = HOMENS SEM CONTAMINACAO");
        System.out.println(espacos + cadastroPessoas.quantidadeSaudaveis('F') + " = MULHERES SEM CONTAMINACAO");
        String total = String.format("%02d",cadastroPessoas.getRegistro().size());
        System.err.println(espacos + total + " = TOTAL DE REGISTROS DE PESSOAS");

    }
    
    public static void mostraPessoa(CadastroPessoas cadastroPessoas, String str) {
        cadastroPessoas.setRegistro(new PessoaDao().carregar());

        str = str.trim();
    	Pessoa pessoa = null;
    	
    	if(Validacao.validaMostraPessoa(str)) {
    		int numero = Integer.parseInt(str);
    		
    		try {
        		
    			pessoa = cadastroPessoas.pesquisaPorId(numero);
        		mostraDadosPessoa(pessoa.toString());
        	
        	}catch(NullPointerException e) {
        		mostraErro("Nao ha uma pessoa cadastrada com esse ID.");
        	}
    	}
    	
    }

}
