package xadrez.pecas;
/**
 * Created by Jeferson. 16/06/2020
 */

import tabuleiro.Posicao;
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

    private boolean podeMover(Posicao posicao){
        PecaXadrez p = (PecaXadrez) getTabuleiro().peca(posicao);
        return p != null && p.getCor() != getCor() ;
    }

    @Override
    public boolean[][] movimentosPosiveis() {
        boolean[][]mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
        Posicao p = new Posicao(0,0);
        //Acima
        p.setValues(posicao.getLinha() -1, posicao.getColuna());
        addMat(mat,p);
        //Abaixo
        p.setValues(posicao.getLinha() + 1, posicao.getColuna());
        addMat(mat,p);
        //Laterais
        p.setValues(posicao.getLinha(), posicao.getColuna() -1);
        addMat(mat,p);

        p.setValues(posicao.getLinha(), posicao.getColuna() + 1);
        addMat(mat,p);

        p.setValues(posicao.getLinha() - 1, posicao.getColuna() +1);
        addMat(mat,p);

        p.setValues(posicao.getLinha() - 1, posicao.getColuna() - 1);
        addMat(mat,p);

        p.setValues(posicao.getLinha() +1, posicao.getColuna() +1);
        addMat(mat,p);

        p.setValues(posicao.getLinha() + 1, posicao.getColuna() -1);
        addMat(mat,p);

        return mat;
    }

    private boolean[][] addMat(boolean[][] mat, Posicao p){
        if(getTabuleiro().existePosicao(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        return mat;
    }
}
