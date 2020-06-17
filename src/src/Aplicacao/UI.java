package Aplicacao;
/*
    Jeferson created on 16/06/2020
*/

import xadrez.PecaXadrez;

public class UI {

    public static void imprimirTabuleiro(PecaXadrez[][] pecas){
        for (int i = 0; i < pecas.length; i++){
            System.out.print((8 - i) + " ");
            for (int j = 0; j<pecas.length; j++){
                imprimirPeca(pecas[i][j]);
            }
            System.out.println();
        }
        System.out.print("  A B C D E F G H");
    }
    private static void imprimirPeca(PecaXadrez peca){
        if(peca == null){
            System.out.print("-");
        }else{
            System.out.print(peca);
        }
        System.out.print(" ");
    }
}
