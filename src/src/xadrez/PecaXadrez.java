package xadrez;
/**
 * Created by Jeferson. 16/06/2020
 */

import tabuleiro.Peca;
import tabuleiro.Tabuleiro;

public abstract class PecaXadrez extends Peca {

    private final Cor cor;

    public PecaXadrez(Tabuleiro tabuleiro, Cor cor) {
        super(tabuleiro);
        this.cor = cor;
    }

    public Cor getCor() {
        return cor;
    }
}
