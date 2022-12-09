package dados;

public class Homem extends Pessoa{
    private Integer idade;

    public Homem(String nome, int numero, char situacaoSaude, int idade) {
        super(nome, numero, situacaoSaude);
        this.idade = idade;
    }

    public String getStringIdade() {
        return idade.toString();
    }
    
    public int getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return new String("Numero: " + getNumero() 
        		 + "\n" + "Nome: " + getNome().toLowerCase() 
        		 + "\n" + "Sexo: " + getSexo()
        		 + "\n" + "Situacao de saude: " + getSaudeExtenso()
        		 + "\n" + "Idade: " + getStringIdade());
    }

    public String getSexo() {
    	return "masculino";
    }

}
