package xadrez;

/*
    Jeferson created on 16/06/2020
*/

import tabuleiro.Peca;
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
        colocarNovaPeca('a', 8,new Torre(tabuleiro,Cor.PRETO));
        colocarNovaPeca('h', 8,new Torre(tabuleiro,Cor.PRETO));
        colocarNovaPeca('a', 1,new Torre(tabuleiro,Cor.BRANCO));
        colocarNovaPeca('h', 1,new Torre(tabuleiro,Cor.BRANCO));

        /*Cavalo*/
        colocarNovaPeca('b', 8, new Cavalo(tabuleiro,Cor.PRETO));
        colocarNovaPeca('g', 8, new Cavalo(tabuleiro,Cor.PRETO));
        colocarNovaPeca('b', 1, new Cavalo(tabuleiro,Cor.BRANCO));
        colocarNovaPeca('g', 1, new Cavalo(tabuleiro,Cor.BRANCO));


        /*Bispo*/
        colocarNovaPeca('c',8, new Bispo(tabuleiro,Cor.PRETO));
        colocarNovaPeca('f',8, new Bispo(tabuleiro,Cor.PRETO));
        colocarNovaPeca('c',1, new Bispo(tabuleiro,Cor.BRANCO));
        colocarNovaPeca('f',1, new Bispo(tabuleiro,Cor.BRANCO));


        /*Dama*/
        colocarNovaPeca('d', 8 , new Dama(tabuleiro,Cor.PRETO));
        colocarNovaPeca('d', 1 , new Dama(tabuleiro,Cor.BRANCO));


        /*Rei*/
        colocarNovaPeca('e', 8, new Rei(tabuleiro,Cor.PRETO));
        colocarNovaPeca('e', 1 ,new Rei(tabuleiro,Cor.BRANCO));


        for(int i = 0; i < tabuleiro.getColunas(); i++){
            int letra = 'a';
            letra = letra + i;
            char c = (char)letra;
            colocarNovaPeca( c,7, new Peao(tabuleiro,Cor.PRETO));
            colocarNovaPeca( c,2, new Peao(tabuleiro,Cor.BRANCO));

        }
    }

    private void colocarNovaPeca(int coluna, int linha, PecaXadrez peca){
        tabuleiro.colocarPeca(peca, new PosicaoXadrez((char) coluna,linha).toPosicao());
    }

    public PecaXadrez moverPeca(PosicaoXadrez posicaoXadrezOrigen, PosicaoXadrez posicaoXadrezFutura){
        Posicao origen = posicaoXadrezOrigen.toPosicao();
        Posicao futura = posicaoXadrezFutura.toPosicao();
        validarPosicaoDeOrigen(origen);
        Peca capturaDePeca = fazerMovimento(origen, futura);

        return (PecaXadrez) capturaDePeca;
    }

    private Peca fazerMovimento(Posicao origen, Posicao futura) {
        Peca peca = tabuleiro.removerPeca(origen);
        Peca pecaCapturada = tabuleiro.removerPeca(futura);
        tabuleiro.colocarPeca(peca,futura);
        return pecaCapturada;
    }

    private void validarPosicaoDeOrigen(Posicao origen) {
        if(!tabuleiro.existePeca(origen)){
            throw new XadrezException("Não existe uma peça nessa posição. ");
        }
    }

}
