package comparadores;

import java.util.Comparator;
import dados.Pessoa;

public class OrdenaPorId implements Comparator<Pessoa> {
    public int compare(Pessoa a, Pessoa b) {
        return a.getNumero() - b.getNumero();
    }
}
