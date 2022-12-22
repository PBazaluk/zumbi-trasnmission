package projetozumbivirus;

/**
 * Classe PessoaImune
 *
 * @author Pedro Bazaluk
 * @version 1.0
 */
public class PessoaImune extends Pessoa implements IMovable {

    /**
     * Construtor Parametrizado da Classe PessoaImune
     *
     * @param x
     * @param y
     */
    public PessoaImune(int x, int y) {
        super(x, y, 6);
    }

}
