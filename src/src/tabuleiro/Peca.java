package tabuleiro;
/*
    Jeferson created on 16/06/2020
*/

public abstract class Peca {
    protected Posicao posicao;
    private Tabuleiro tabuleiro;

    public Peca(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
        posicao = null;
    }
    public abstract boolean [][] movimentosPosiveis();

    public boolean movimentoPosivel(Posicao posicao){
        return movimentosPosiveis()[posicao.getLinha()][posicao.getColuna()];
    }

    public boolean existeAlgumMovimentoPosivei (){
        boolean [][] movs = movimentosPosiveis();
        for(int i = 0; i < movs.length; i++){
            for(int j=0; j<movs.length;j++){
                if(movs[i][j]){
                    return true;
                }
            }
        }
        return false;
    }

    protected Tabuleiro getTabuleiro() {
        return tabuleiro;
    }


}
