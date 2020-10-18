package xadrez.pecas;
/**
 * Created by Jeferson. 17/06/2020
 */

import tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Dama extends PecaXadrez {

    public Dama(Tabuleiro tabuleiro, Cor cor) {
        super(tabuleiro, cor);
    }

    @Override
    public String toString(){
        return "\u2655";
    }

    @Override
    public boolean[][] movimentosPosiveis() {
        return new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
    }
}
