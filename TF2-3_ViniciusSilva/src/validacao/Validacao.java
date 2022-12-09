package validacao;


import dados.CadastroPessoas;
import saida.Visao;

public class Validacao {
    public static int validaNome(String nome){
        int status;
        nome = nome.trim();
        
        if(nome.isEmpty() || !nome.contains(" ") || nome.length() <= 2) {
        	Visao.mostraErro("Digite o nome completo.");
        	status = -1;
                
        }else
        	status = 1;

        return status;

    }
    
    public static int validaNumero(String id, CadastroPessoas cadastroPessoas){
        int numero = 0;
        final int MAIOR = 100;
        int status = 1;
       
            try{
            	
                numero = Integer.parseInt(id);

                if(numero <= MAIOR){
                    String mensagem = "ID: O numero deve ser maior que " + MAIOR;
                    Visao.mostraErro(mensagem);
                    status = -1;
                }
            }catch(NumberFormatException e) {
            	Visao.mostraErro("ID: Digite um numero valido.");
            	status = -1;
            }
            if(checaRepeticaoNumero(numero, cadastroPessoas))
            	status = -1;
            
        return status;
    }

    public static int validaSituacaoSaude(char situacao){
        int status = 1;
    	
    	if(situacao == 'N') {
    		Visao.mostraErro("Selecione uma situacao de saude.");
    		status = -1;
    	}

        return status;
    }

    public static int validaIdade(String idade){
        int idadeInt;
        int status = 1;
        idade = idade.trim();
        
        try{
                
        	idadeInt = Integer.parseInt(idade);
            if(idadeInt < 0 || idadeInt >= 150){
            	Visao.mostraErro("Informe uma idade entre 0 e 150.");
            	status = -1;
            }
       }catch(NumberFormatException e){
            Visao.mostraErro("Idade: Tipo de dado invalido.");
            status = -1; 
       }
       

        return status;

    }

    public static int validaGravidez(char gravidez) {
    	int status = 1;
    	
    	if(gravidez == ' ') {
    		Visao.mostraErro("Gravidez: Selecione uma opcao.");
    		status = -1;
    	}

        return status;
    	
    }

    public static boolean checaRepeticaoNumero(int check, CadastroPessoas cadastroPessoas){
        int i=0;

        while(i< cadastroPessoas.getRegistro().size()){
            if(check == cadastroPessoas.getRegistro().get(i).getNumero()){
                Visao.mostraErro("ID: Numero ja cadastrado.");
                return true;
            }
            i++;
        }

        return false;
    }
    
    public static boolean validaMostraPessoa(String s) {
        final int MAIOR = 100;
        int num;

            try{
            	
            	num = Integer.parseInt(s);
            	
                if(num <= MAIOR){
                    String mensagem = "O numero deve ser maior que " + MAIOR;
                    Visao.mostraErro(mensagem); 
                    return false;
                }
            }catch(NumberFormatException e) {
            	Visao.mostraErro("Digite um numero valido.");      
            	return false;
            }
            
            return true;
            
   }

    public static int validaPesquisaNome(String nome){
        int status;
        nome = nome.trim();

        if(nome.isEmpty()) {
            Visao.mostraErro("Digite um nome.");
            status = -1;

        }else
            status = 1;

        return status;

    }
}
