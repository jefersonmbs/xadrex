package xadrez.pecas;
/*
    Jeferson created on 16/06/2020
*/

import tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Torre extends PecaXadrez {

    public Torre(Tabuleiro tabuleiro, Cor cor) {
        super(tabuleiro, cor);
    }


    @Override
    public String toString(){
        return "\u2656";
    }

    @Override
    public boolean[][] movimentosPosiveis() {
        return new boolean [getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
    }
}
