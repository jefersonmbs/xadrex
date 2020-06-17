package xadrez;
/*
    jeferson created on 16/06/2020
*/

import tabuleiro.Peca;
import tabuleiro.Tabuleiro;

public class PecaXadrez  extends Peca {

    private Cor cor;

    public PecaXadrez(Tabuleiro tabuleiro, Cor cor) {
        super(tabuleiro);
        this.cor = cor;
    }

    public Cor getCor() {
        return cor;
    }
}
