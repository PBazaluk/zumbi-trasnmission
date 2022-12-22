package projetozumbivirus;

/**
 * Classe Zumbi
 *
 * @author Pedro Bazaluk
 * @version 1.0
 */
public class Zumbi extends Pessoa implements IMovable {

    /**
     * Construtor Parametrizado da Classe Zumbi
     *
     * @param x
     * @param y
     */
    public Zumbi(int x, int y) {
        super(x, y, 4);
    }
}
