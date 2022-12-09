package dados;

public class Mulher extends Pessoa{
    private Character foiGestante;

    public Mulher(String nome, int numero, char situacaoSaude, char foiGestante) {
        super(nome, numero, situacaoSaude);
        setFoiGestante(foiGestante);
    }

    public String getGestacaoString() {
        return gestacaoToExtenso(foiGestante);
    }

    public void setFoiGestante(Character foiGestante) {
        this.foiGestante = foiGestante;
    }
    
    public char getGestacao() {
        return foiGestante;
    }

    @Override
    public String toString() {
        return new String("Numero: " + getNumero() 
        		 + "\n" + "Nome: " + getNome().toLowerCase()
        		 + "\n" + "Sexo: " + getSexo()
        		 + "\n" + "Situacao de saude: " + getSaudeExtenso()
        		 + "\n" + "Situacao de gravidez: " + getGestacaoString());
    }

    public String gestacaoToExtenso(char c) {
        String s;

        if (c == 'S')
            s = "sim";
        else if (c == 'N')
            s = "nao";
        else
            s = "incerto";

        return s;
    }
    
    public String getSexo() {
    	return "feminino";
    }
    
}
