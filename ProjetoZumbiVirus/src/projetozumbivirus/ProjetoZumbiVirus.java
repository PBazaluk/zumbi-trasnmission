package projetozumbivirus;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Pedro Bazaluk
 * @version 1.0
 */
public class ProjetoZumbiVirus {

    public static final String ANSI_WHITE_BACKGROUND = "\u001b[47m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001b[42m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001b[44m";
    public static final String ANSI_RED_BACKGROUND = "\u001b[41m";
    public static final String ANSI_MAG_BACKGROUND = "\u001b[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001b[46m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001b[43m";
    public int Att;

    public static void main(String[] args) {
        Mundo m = new Mundo();
        Random rd = new Random();

        ArrayList<Pessoa> lp;
        lp = new ArrayList<Pessoa>();

        /**
         * Criando um ArrayList de Pessoa
         */
        for (int i = 0; i < 103; i++) {
            int x = rd.nextInt(27) + 1;
            int y = rd.nextInt(87) + 1;
            switch (i) {
                case 0:
                case 1: {
                    Pessoa p = new Zumbi(x, y);
                    lp.add(p);
                    break;
                }
                case 2: {
                    Pessoa p = new PessoaImune(x, y);
                    lp.add(p);
                    break;
                }
                default: {
                    Pessoa p = new PessoaSaudavel(x, y);
                    lp.add(p);
                    break;
                }
            }
        }

        /**
         * Definindo os contadores que serão exibidos
         */
        int Tps = 100;
        int Tpd = 0;
        int Tpi = 1;
        int Tz = 2;

        while (true) {

            /**
             * Printando os contadores
             */
            System.out.println(ANSI_WHITE_BACKGROUND + "Total de pessoas: 103");
            System.out.print(ANSI_BLUE_BACKGROUND + " ");
            System.out.print(ANSI_WHITE_BACKGROUND + "Saudáveis: " + Tps + "        ");
            System.out.print(ANSI_RED_BACKGROUND + " ");
            System.out.print(ANSI_WHITE_BACKGROUND + "Doentes: " + Tpd + "        ");
            System.out.print(ANSI_GREEN_BACKGROUND + " ");
            System.out.print(ANSI_WHITE_BACKGROUND + "Zumbi: " + Tz + "        ");
            System.out.print(ANSI_YELLOW_BACKGROUND + " ");
            System.out.print(ANSI_WHITE_BACKGROUND + "Pessoa Imune: " + Tpi + "        ");
            System.out.print(ANSI_MAG_BACKGROUND + " ");
            System.out.println(ANSI_WHITE_BACKGROUND + ":Hospital         ");

            /**
             * Colocando todos os objetos do ArrayList no mundo e fazendo eles
             * se moverem
             */
            for (int j = 0; j < 103; j++) {
                m.setP(lp.get(j));

                m.atualizaMundo();
                m.setCorNoMapa();

            }
            /**
             * Verificações individuais de infecção, se uma PessoaDoente entrou
             * em um hospital, e passanda a imunidade
             */
            for (int j = 0; j < 103; j++) {
                m.setP(lp.get(j));
                /**
                 * Verificando se uma Pessoa Doente entrou em um Hospital
                 */
                if (lp.get(j).getCor() == 3) {
                    if (lp.get(j).getX() <= 26 && lp.get(j).getX() >= 22 && lp.get(j).getY() <= 12 && lp.get(j).getY() >= 5) {

                        Pessoa n = new PessoaSaudavel(lp.get(j).getX(), lp.get(j).getY());
                        lp.add(n);
                        lp.remove(lp.get(j));
                        Tpd -= 1;
                        Tps += 1;
                    } else if (lp.get(j).getX() <= 8 && lp.get(j).getX() >= 4 && lp.get(j).getY() <= 37 && lp.get(j).getY() >= 30) {

                        Pessoa n = new PessoaSaudavel(lp.get(j).getX(), lp.get(j).getY());
                        lp.add(n);
                        lp.remove(lp.get(j));
                        Tpd -= 1;
                        Tps += 1;
                    } else if (lp.get(j).getX() <= 20 && lp.get(j).getX() >= 16 && lp.get(j).getY() <= 77 && lp.get(j).getY() >= 70) {

                        Pessoa n = new PessoaSaudavel(lp.get(j).getX(), lp.get(j).getY());
                        lp.add(n);
                        lp.remove(lp.get(j));
                        Tpd -= 1;
                        Tps += 1;
                    }
                }
                /**
                 * Infectando quando esta na mesma posição ou perto de um Zumbi
                 * ou de uma Pessoa Doente
                 */
                for (int k = 0; k < 103; k++) {
                    if (lp.get(j).getCor() != 3 && lp.get(j).getCor() != 4 && lp.get(j).getCor() != 6) {
                        if (k != j) {
                            if (lp.get(k).getX() == lp.get(j).getX() && lp.get(k).getY() == lp.get(j).getY()) {
                                if (lp.get(k).getCor() == 3 || lp.get(k).getCor() == 4) {

                                    Pessoa n = new PessoaDoente(lp.get(j).getX(), lp.get(j).getY());
                                    n.iniciaContador();
                                    lp.add(n);
                                    lp.remove(lp.get(j));
                                    Tps -= 1;
                                    Tpd += 1;
                                }
                            }
                            if (lp.get(k).getX() == (lp.get(j).getX() + 1) && lp.get(k).getY() == lp.get(j).getY()) {
                                if (lp.get(k).getCor() == 3 || lp.get(k).getCor() == 4) {

                                    Pessoa n = new PessoaDoente(lp.get(j).getX(), lp.get(j).getY());
                                    n.iniciaContador();
                                    lp.add(n);
                                    lp.remove(lp.get(j));
                                    Tps -= 1;
                                    Tpd += 1;
                                }
                            }
                            if (lp.get(k).getX() == lp.get(j).getX() && lp.get(k).getY() == (lp.get(j).getY() + 1)) {
                                if (lp.get(k).getCor() == 3 || lp.get(k).getCor() == 4) {

                                    Pessoa n = new PessoaDoente(lp.get(j).getX(), lp.get(j).getY());
                                    n.iniciaContador();
                                    lp.add(n);
                                    lp.remove(lp.get(j));
                                    Tps -= 1;
                                    Tpd += 1;
                                }
                            }
                            if (lp.get(k).getX() == (lp.get(j).getX() - 1) && lp.get(k).getY() == (lp.get(j).getY())) {
                                if (lp.get(k).getCor() == 3 || lp.get(k).getCor() == 4) {

                                    Pessoa n = new PessoaDoente(lp.get(j).getX(), lp.get(j).getY());
                                    n.iniciaContador();
                                    lp.add(n);
                                    lp.remove(lp.get(j));
                                    Tps -= 1;
                                    Tpd += 1;
                                }
                            }
                            if (lp.get(k).getX() == (lp.get(j).getX()) && lp.get(k).getY() == (lp.get(j).getY() - 1)) {
                                if (lp.get(k).getCor() == 3 || lp.get(k).getCor() == 4) {

                                    Pessoa n = new PessoaDoente(lp.get(j).getX(), lp.get(j).getY());
                                    n.iniciaContador();
                                    lp.add(n);
                                    lp.remove(lp.get(j));
                                    Tps -= 1;
                                    Tpd += 1;
                                }
                            }
                        }
                    }
                    /**
                     * Verificando se uma pessoa imune passa sua imunidade
                     * (apenas se estiverem na mesma posição)
                     */
                    if (lp.get(j).getCor() != 6) {
                        if (k != j) {
                            if (lp.get(k).getX() == lp.get(j).getX() && lp.get(k).getY() == lp.get(j).getY()) {
                                if (lp.get(k).getCor() == 6) {

                                    Pessoa n = new PessoaImune(lp.get(j).getX(), lp.get(j).getY());
                                    lp.add(n);
                                    switch (lp.get(j).getCor()) {
                                        case 2:
                                            Tps -= 1;
                                            Tpi += 1;
                                            break;
                                        case 3:
                                            Tpd -= 1;
                                            Tpi += 1;
                                            break;
                                        case 4:
                                            Tz -= 1;
                                            Tpi += 1;
                                            break;
                                        default:
                                            break;
                                    }
                                    lp.remove(lp.get(j));
                                }
                            }
                        }
                    }

                }
                /**
                 * Sempre executando e verificando se ja se passaram 15 segundos
                 * para que uma PessoaDoente possa se tornar um Zumbi
                 */
                if (lp.get(j).getCor() == 3) {
                    if (lp.get(j).terminaContador()) {
                        Pessoa n = new Zumbi(lp.get(j).getX(), lp.get(j).getY());
                        lp.remove(lp.get(j));
                        lp.add(n);
                        Tpd -= 1;
                        Tz += 1;
                    }
                }
                /**
                 * Atualiza a posição do objeto Pessoa na matriz
                 */
                m.setCorNoMapa();
            }

            /**
             * Printa o mundo
             */
            m.desenhaMundo();
            /**
             * Recria o mundo para não manter os rastros
             */
            m.recriaMundo();
            try {
                Thread.sleep(300);
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println("");
        }
    }

}
