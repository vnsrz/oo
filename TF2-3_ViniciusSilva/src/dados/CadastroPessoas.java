package dados;

import validacao.Validacao;
import java.util.ArrayList;

import dao.PessoaDao;

public class CadastroPessoas {
    ArrayList<Pessoa> registro;

    public CadastroPessoas(ArrayList<Pessoa> arrayList) {
        this.registro = arrayList;
    }

    public ArrayList<Pessoa> getRegistro() {
        return registro;
    }

    public void setRegistro(ArrayList<Pessoa> registro){
        this.registro = registro;
    }

    public int cadastraHomem(String nome, String id, char saude, String idade, CadastroPessoas cadastroPessoas){
        int status=1;
        
        if(Validacao.validaNome(nome) == 1) {
            if(Validacao.validaNumero(id, cadastroPessoas) == 1) {
            	if(Validacao.validaSituacaoSaude(saude) == 1) {
            		if(Validacao.validaIdade(idade) == 1) {
            			Homem homem = new Homem(nome, Integer.parseInt(id), saude, Integer.parseInt(idade));
                        new PessoaDao().cadastrar(homem);
                    }else status = -1;
                }else status = -1;
            }else status = -1;
        }else status = -1;
        
        
        return status;

    }

    public int cadastraMulher(String nome, String id, char saude, char gravidez, CadastroPessoas cadastroPessoas){
          int status=1;
          
          if(Validacao.validaNome(nome) == 1) {
        	  if(Validacao.validaNumero(id, cadastroPessoas) == 1) {
        		  if(Validacao.validaSituacaoSaude(saude) == 1) {
        			  if(Validacao.validaGravidez(gravidez) == 1) {
        				  Mulher mulher = new Mulher(nome, Integer.parseInt(id), saude, gravidez);
                          new PessoaDao().cadastrar(mulher);
                      }else status = -1;
        		  }else status = -1;
        	  }else status = -1;
          }else status = -1;
          
          return status;

    }

    public String quantidadeContaminacoes(char condicao) {
        int aux = 0;

        for (Pessoa pessoa : this.getRegistro()) {
            if (pessoa.getSituacaoSaude() == condicao) {
                aux++;
            }
        }

        return String.format("%02d",aux);

    }

    public String quantidadeSaudaveis(char sexo) {

        int aux = 0;

        if(sexo == 'M'){
            for (Pessoa pessoa : this.getRegistro()) {
                if(pessoa.getSexo().equals("masculino")){
                    if(pessoa.getSituacaoSaude() == 'S'){
                        aux++;
                    }
                }
            }
        }else
            for (Pessoa pessoa : this.getRegistro()) {
                if(pessoa.getSexo().equals("feminino")){
                    if(pessoa.getSituacaoSaude() == 'S'){
                        aux++;
                    }
                }
            }

        return String.format("%02d",aux);

    }

    public Pessoa pesquisaPorId(int num) {
    	int i=0;
    	
    	while(i< this.getRegistro().size()){
            if(num == this.getRegistro().get(i).getNumero()){
                return this.getRegistro().get(i);
            }
            i++;
    	}
    	return null;
    }
}

	
