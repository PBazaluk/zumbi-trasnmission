package projetozumbivirus;

/**
 * Classe PessoaDoente
 *
 * @author Pedro Bazaluk
 * @version 1.0
 */
public class PessoaDoente extends Pessoa implements IMovable {

    private Virus v;
    private long contI;
    private long contF;

    /**
     * Construtor Parametrizado da Classe PessoaDoente
     *
     * @param x
     * @param y
     */
    public PessoaDoente(int x, int y) {
        super(x, y, 3);
    }

    /**
     * Inicia o contador quando se torna PessoaDoente
     */
    @Override
    public void iniciaContador() {
        contI = System.currentTimeMillis();
    }

    /**
     * Verifica quanto tempo se passou desde quando foi executado
     * iniciaContador()
     *
     * @return true quando chegar ou ultrapassar os 15 segundos
     */
    @Override
    public boolean terminaContador() {
        contF = System.currentTimeMillis() - contI;
        return contF > 15000;
    }

}
