package projetozumbivirus;

import java.util.Random;

/**
 * Classe Pessoa. Fornece metodos e atributos para o registro de pessoas objeto
 *
 * @author Pedro Bazaluk
 * @version 1.0
 */
public class Pessoa {

    private int x;
    private int y;
    private int cor;

    /**
     * Construtor Parametrizado da Classe Pessoa
     *
     * @param x
     * @param y
     * @param cor
     */
    public Pessoa(int x, int y, int cor) {
        this.x = x;
        this.y = y;
        this.cor = cor;
    }

    /**
     * Movimenta de forma aleatória objetos do tipo Pessoa dentro da matriz
     */
    public void mover() {

        Random rd = new Random();
        int rand = rd.nextInt(4);

        if (rand == 0) {
            setX(getX() + 1);
        }
        if (rand == 1) {
            setX(getX() - 1);
        }
        if (rand == 2) {
            setY(getY() + 1);
        }
        if (rand == 3) {
            setY(getY() - 1);
        }
        if (getX() == 29) {
            setX(1);
        }
        if (getX() == 0) {
            setX(28);
        }
        if (getY() == 89) {
            setY(1);
        }
        if (getY() == 0) {
            setY(88);
        }
    }

    /**
     * Função usada para iniciar o contador para PessoaDoente
     */
    public void iniciaContador() {
    }

    /**
     * Função usada para terminar o contador e verificar se passaram 15 segundos
     *
     * @return true
     */
    public boolean terminaContador() {
        return true;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the cor
     */
    public int getCor() {
        return cor;
    }

    /**
     * @param cor the cor to set
     */
    public void setCor(int cor) {
        this.cor = cor;
    }

}
