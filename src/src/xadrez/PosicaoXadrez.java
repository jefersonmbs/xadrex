package xadrez;

/*
    Jeferson created on 17/06/2020
    Linha da Matrix = 8 - this.linha
    Coluna da Matrix = this.coluna - 'a'
    Unicode
*/

import tabuleiro.Posicao;

public class PosicaoXadrez {

    private char coluna;
    private int linha;

    public PosicaoXadrez(char coluna, int linha) {
        if(coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8){
            throw new XadrezException("Pocição invalida, Posições validas: de a1 até a h8");
        }
        this.coluna = coluna;
        this.linha = linha;
    }

    public char getColuna() {
        return coluna;
    }


    public int getLinha() {
        return linha;
    }
    protected Posicao toPosicao(){
        return new Posicao(8 - linha, coluna - 'a');
    }

    protected static PosicaoXadrez castPosicaoXadrex (Posicao posicao){
        return new PosicaoXadrez((char) ('a' - posicao.getColuna()), 8 - posicao.getLinha());
    }

    @Override
    public String toString(){
        return ""+coluna + linha;
    }
}
