package comparadores;

import dados.Pessoa;

import java.util.Comparator;

public class OrdenaPorNome implements Comparator<Pessoa>{
    public int compare(Pessoa a, Pessoa b) {
            return a.getNome().compareTo(b.getNome());
        }
}
