package xadrez.pecas;

/*
    Jeferson created on 17/06/2020
*/

import tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Peao extends PecaXadrez {
    public Peao(Tabuleiro tabuleiro, Cor cor) {
        super(tabuleiro, cor);
    }
    //Fazer os Tipos de Movimento da peça

    @Override
    public String toString(){
        return "\u2659";
    }
}
