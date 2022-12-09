package dados;

public abstract class Pessoa {
    private StringBuilder nome;
    private Integer numero;
    private Character situacaoSaude;

    public Pessoa(String nome, Integer numero, Character situacaoSaude) {
        this.nome = new StringBuilder(nome);
        this.numero = numero;
        this.situacaoSaude = situacaoSaude;
    }

    public String getNome() {
        return nome.toString();
    }

    public Integer getNumero() {
        return numero;
    }

    public char getSituacaoSaude() {
        return situacaoSaude;
    }
    
    public String getSaudeExtenso() {
        return charToExtenso(situacaoSaude);
    }

    public String getGestacaoString() {
        return null;
    }
    
    public String getGestacaoToString() {
    	return null;
    }
    
    public String getStringIdade() {
    	return null;
    }
    
    public int getIdade() {
        return -1;
    }
    
    public char getGestacao() {
        return ' ';
    }
    
    public String charToExtenso(char c) {
        String s;

        if(c == 't')
            s = "contaminada em tratamento";
        else if (c == 'f')
            s = "contaminada falecida";
        else if (c == 'c')
            s = "contaminada curada";
        else
            s = "sem contaminacao";

        return s;
    }
    
    public abstract String getSexo();
    
}