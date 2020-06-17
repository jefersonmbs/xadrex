package xadrez;

/*
    Jeferson created on 16/06/2020
*/

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.pecas.*;

public class Partida {

    private Tabuleiro tabuleiro;
    private static final int linhas = 8;
    private static final int colunas = 8;

    public Partida(){

        tabuleiro = new Tabuleiro(linhas,colunas);
        posicoesIniciais();
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public PecaXadrez[][] getPecas(){
        PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
        for(int i = 0; i < tabuleiro.getLinhas(); i++){
            for (int j = 0 ; j < tabuleiro.getColunas(); j ++){
                mat[i][j] = (PecaXadrez) tabuleiro.peca(i,j);
            }
        }
        return mat;
    }

    private void posicoesIniciais(){

        /*Torres*/
        tabuleiro.colocarPeca(new Torre(tabuleiro,Cor.PRETO),new Posicao(0,0));
        tabuleiro.colocarPeca(new Torre(tabuleiro,Cor.PRETO),new Posicao(0,7));
        tabuleiro.colocarPeca(new Torre(tabuleiro,Cor.BRANCO),new Posicao(7,0));
        tabuleiro.colocarPeca(new Torre(tabuleiro,Cor.BRANCO),new Posicao(7,7));

        /*Cavalo*/
        tabuleiro.colocarPeca(new Cavalo(tabuleiro,Cor.PRETO),new Posicao(0,1));
        tabuleiro.colocarPeca(new Cavalo(tabuleiro,Cor.PRETO),new Posicao(0,6));
        tabuleiro.colocarPeca(new Cavalo(tabuleiro,Cor.BRANCO),new Posicao(7,1));
        tabuleiro.colocarPeca(new Cavalo(tabuleiro,Cor.BRANCO),new Posicao(7,6));

        /*Bispo*/
        tabuleiro.colocarPeca(new Bispo(tabuleiro,Cor.PRETO),new Posicao(0,2));
        tabuleiro.colocarPeca(new Bispo(tabuleiro,Cor.PRETO),new Posicao(0,5));
        tabuleiro.colocarPeca(new Bispo(tabuleiro,Cor.BRANCO),new Posicao(7,2));
        tabuleiro.colocarPeca(new Bispo(tabuleiro,Cor.BRANCO),new Posicao(7,5));

        /*Dama*/
        tabuleiro.colocarPeca(new Dama(tabuleiro,Cor.PRETO), new Posicao(0,3));
        tabuleiro.colocarPeca(new Dama(tabuleiro,Cor.BRANCO), new Posicao(7,3));

        /*Rei*/
        tabuleiro.colocarPeca(new Rei(tabuleiro,Cor.PRETO),new Posicao(0,4));
        tabuleiro.colocarPeca(new Rei(tabuleiro,Cor.BRANCO),new Posicao(7,4));

        for(int i = 0; i < tabuleiro.getLinhas(); i++){
            tabuleiro.colocarPeca(new Peao(tabuleiro,Cor.PRETO), new Posicao(1,i));
            tabuleiro.colocarPeca(new Peao(tabuleiro,Cor.BRANCO), new Posicao(6,i));
        }


    }
}
