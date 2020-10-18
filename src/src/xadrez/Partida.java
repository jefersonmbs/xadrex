package xadrez;

/**
 * Created by Jeferson. 16/06/2020
 */

import tabuleiro.Peca;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.pecas.*;

public class Partida {

    private static final int linhas = 8;
    private static final int colunas = 8;
    private final Tabuleiro tabuleiro;

    public Partida() {

        tabuleiro = new Tabuleiro(linhas, colunas);
        posicoesIniciais();
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public PecaXadrez[][] getPecas() {
        PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
        for (int i = 0; i < tabuleiro.getLinhas(); i++) {
            for (int j = 0; j < tabuleiro.getColunas(); j++) {
                mat[i][j] = (PecaXadrez) tabuleiro.peca(i, j);
            }
        }
        return mat;
    }

    private void posicoesIniciais() {

        /*Torres*/
        colocarNovaPeca('a', 8, new Torre(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('h', 8, new Torre(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('a', 1, new Torre(tabuleiro, Cor.PRETO));
        colocarNovaPeca('h', 1, new Torre(tabuleiro, Cor.PRETO));

        /*Cavalo*/
        colocarNovaPeca('b', 8, new Cavalo(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('g', 8, new Cavalo(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('b', 1, new Cavalo(tabuleiro, Cor.PRETO));
        colocarNovaPeca('g', 1, new Cavalo(tabuleiro, Cor.PRETO));


        /*Bispo*/
        colocarNovaPeca('c', 8, new Bispo(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('f', 8, new Bispo(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('c', 1, new Bispo(tabuleiro, Cor.PRETO));
        colocarNovaPeca('f', 1, new Bispo(tabuleiro, Cor.PRETO));


        /*Dama*/
        colocarNovaPeca('d', 8, new Dama(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('d', 1, new Dama(tabuleiro, Cor.PRETO));


        /*Rei*/
        colocarNovaPeca('e', 8, new Rei(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('e', 1, new Rei(tabuleiro, Cor.PRETO));


        for (int i = 0; i < tabuleiro.getColunas(); i++) {
            int letra = 'a';
            letra = letra + i;
            char c = (char) letra;
            colocarNovaPeca(c, 7, new Peao(tabuleiro, Cor.BRANCO));
            colocarNovaPeca(c, 2, new Peao(tabuleiro, Cor.PRETO));

        }
    }

    private void colocarNovaPeca(int coluna, int linha, PecaXadrez peca) {
        tabuleiro.colocarPeca(peca, new PosicaoXadrez((char) coluna, linha).toPosicao());
    }

    public PecaXadrez moverPeca(PosicaoXadrez posicaoXadrezOrigen, PosicaoXadrez posicaoXadrezFutura) {
        Posicao origen = posicaoXadrezOrigen.toPosicao();
        Posicao futura = posicaoXadrezFutura.toPosicao();
        validarPosicaoDeOrigen(origen);
        validarPosicaoDeDestino(origen, futura);
        Peca capturaDePeca = fazerMovimento(origen, futura);

        return (PecaXadrez) capturaDePeca;
    }

    private Peca fazerMovimento(Posicao origen, Posicao futura) {
        Peca peca = tabuleiro.removerPeca(origen);
        Peca pecaCapturada = tabuleiro.removerPeca(futura);
        tabuleiro.colocarPeca(peca, futura);
        return pecaCapturada;
    }

    private void validarPosicaoDeOrigen(Posicao origen) {
        if (!tabuleiro.existePeca(origen)) {
            throw new XadrezException("Não existe uma peça nessa posição. ");
        }
        if (!tabuleiro.peca(origen).existeAlgumMovimentoPosivei()) {
            throw new XadrezException("Não existe um movimento para essa peça. ");
        }
    }
    private void validarPosicaoDeDestino(Posicao origen, Posicao destino){
        if(!tabuleiro.peca(origen).movimentoPosivel(destino)){
            throw new XadrezException("A peça escolhida não pode se mover para a posição de destino. ");
        }
    }

}
