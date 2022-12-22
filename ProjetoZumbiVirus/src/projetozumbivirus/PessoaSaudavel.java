package projetozumbivirus;

/**
 * Classe PessoaSaudavel
 *
 * @author Pedro Bazaluk
 * @version 1.0
 */
public class PessoaSaudavel extends Pessoa implements IMovable {

    /**
     * Contrutor Parametrizado da Classe PessoaSaudavel
     *
     * @param x
     * @param y
     */
    public PessoaSaudavel(int x, int y) {
        super(x, y, 2);
    }

}
