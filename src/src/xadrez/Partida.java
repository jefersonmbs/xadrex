package xadrez;

/*
    Jeferson created on 16/06/2020
*/

import tabuleiro.Tabuleiro;

public class Partida {

    private Tabuleiro tabuleiro;
    private static final int linhas = 8;
    private static final int colunas = 8;

    public Partida(){

        tabuleiro = new Tabuleiro(linhas,colunas);
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
}
