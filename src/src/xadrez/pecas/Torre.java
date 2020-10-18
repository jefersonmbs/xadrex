package xadrez.pecas;
/**
 * Created by Jeferson. 16/06/2020
 */

import tabuleiro.Posicao;
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
        boolean [][] mat  = new boolean [getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
        Posicao p = new Posicao(0,0);

        //Acime
        p.setValues(posicao.getLinha() - 1 , posicao.getColuna());
        while (getTabuleiro().existePosicao(p) && !getTabuleiro().existePeca(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            p.setLinha(p.getLinha() - 1);
        }
        if(getTabuleiro().existePosicao(p) && existeUmaPecaAdversaria(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }

        p.setValues(posicao.getLinha() + 1 , posicao.getColuna());
        while (getTabuleiro().existePosicao(p) && !getTabuleiro().existePeca(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            p.setLinha(p.getLinha() + 1);
        }
        if(getTabuleiro().existePosicao(p) && existeUmaPecaAdversaria(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }

        //letralmeten
        p.setValues(posicao.getLinha(), posicao.getColuna() - 1);
        while (getTabuleiro().existePosicao(p) && !getTabuleiro().existePeca(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            p.setColuna(p.getColuna() - 1);
        }
        if(getTabuleiro().existePosicao(p) && existeUmaPecaAdversaria(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }

        p.setValues(posicao.getLinha(), posicao.getColuna() + 1);
        while (getTabuleiro().existePosicao(p) && !getTabuleiro().existePeca(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            p.setColuna(p.getColuna() + 1);
        }
        if(getTabuleiro().existePosicao(p) && existeUmaPecaAdversaria(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        return mat;
    }



}
