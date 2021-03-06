package xadrez.pecas;

/**
 * Created by Jeferson. 16/06/2020
 */

import tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Bispo extends PecaXadrez {
    public Bispo(Tabuleiro tabuleiro, Cor cor) {
        super(tabuleiro, cor);
    }
    //Fazer os Tipos de Movimento da peça

    @Override
    public String toString(){
        return "\u2657";
    }

    @Override
    public boolean[][] movimentosPosiveis() {
        return new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
    }
}
