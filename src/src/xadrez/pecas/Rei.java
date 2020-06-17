package xadrez.pecas;
/*
    jeferson created on 16/06/2020
*/

import tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Rei extends PecaXadrez {
    public Rei(Tabuleiro tabuleiro, Cor cor) {
        super(tabuleiro, cor);
    }
    //Fazer os Tipos de Movimento da peça


    @Override
    public String toString(){
        return "\u2654";
    }
}
