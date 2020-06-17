package Aplicacao;
/*
    Jeferson created on 16/06/2020
*/

import tabuleiro.Tabuleiro;
import xadrez.PecaXadrez;

public class UI {

    // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

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
/*
            if (piece.getColor() == Color.WHITE) {
            }	                System.out.print(ANSI_WHITE + piece + ANSI_RESET);
            System.out.print(" ");	            }
        else {
            System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
        }
            */


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
