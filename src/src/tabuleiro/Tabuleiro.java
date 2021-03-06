package tabuleiro;

/**
 * Created by Jeferson. 16/06/2020
 */

public class Tabuleiro {
    private final int linhas;
    private final int colunas;
    private final Peca[][] pecas;

    public Tabuleiro(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        pecas = new Peca[linhas][colunas];
    }

    public int getLinhas() {
        return linhas;
    }

    public int getColunas() {
        return colunas;
    }

    public Peca peca(int linha, int coluna) {
        if (!existePosicao(linha, coluna)) {
            throw new TabuleiroExeption("Posição inexistente no tabuleiro. ");
        }
        return pecas[linha][coluna];
    }

    public Peca peca(Posicao posicao) {
        if (!existePosicao(posicao)) {
            throw new TabuleiroExeption("Posição inexistente no tabuleiro. ");
        }
        return pecas[posicao.getLinha()][posicao.getColuna()];
    }

    public void colocarPeca(Peca peca, Posicao posicao) {
        if (existePeca(posicao)) {
            throw new TabuleiroExeption("Já existe uma peça nessa posição. ");
        }
        pecas[posicao.getLinha()][posicao.getColuna()] = peca;
        peca.posicao = posicao;
    }

    private Boolean existePosicao(int linha, int coluna) {
        return (linha >= 0 && linha < linhas) && (coluna >= 0 && coluna < colunas);
    }

    public Boolean existePosicao(Posicao posicao) {
        return existePosicao(posicao.getLinha(), posicao.getColuna());
    }

    public Boolean existePeca(Posicao posicao) {
        if (!existePosicao(posicao)) {
            throw new TabuleiroExeption("Posição inexistente no tabuleiro. ");
        }
        return peca(posicao) != null;

    }

    public Peca removerPeca(Posicao posicao) {
        if (!existePosicao(posicao)) {
            throw new TabuleiroExeption("Posição inexistente no tabuleiro. ");
        }
        if (peca(posicao) == null) {
            return null;
        }
        Peca pecaRemovida = peca(posicao);
        pecaRemovida.posicao = null;
        pecas[posicao.getLinha()][posicao.getColuna()] = null;
        return pecaRemovida;
    }

}
