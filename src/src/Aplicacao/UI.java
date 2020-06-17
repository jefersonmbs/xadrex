package Aplicacao;
/*
    Jeferson created on 16/06/2020
*/

import tabuleiro.Tabuleiro;
import xadrez.PecaXadrez;

public class UI {

    public static void imprimirTabuleiro(PecaXadrez[][] pecas){
        for (int i = 0; i < pecas.length; i++){
            System.out.print((8 - i) + " ");
            for (int j = 0; j<pecas.length; j++){
                imprimirPeca(pecas[i][j], j,i);
            }
            System.out.println();
        }
        System.out.print("  A  B C  D  E F  G  H");
    }
    private static void imprimirPeca(PecaXadrez peca,int j,int i){
        if(peca == null){
            //linha Impar inicio Preto
            //Linha Par inicio Branco

            //Verifica se a linha é par
            //TODO Melhorar essa logica
            if(i % 2 == 0){
                if(j%2 == 0){
                    //Quadrado Petro Branco
                    System.out.print("\u25AC");
                }else{
                    //Quadrado Branco Preto
                    System.out.print("\u25AD");
                }
            }else if(i % 2 != 0){
                if(j%2 == 0){
                    System.out.print("\u25AD");
                }else {
                    System.out.print("\u25AC");
                }
            }
        }else{
            System.out.print(peca);
        }
        System.out.print(" ");
    }
}
