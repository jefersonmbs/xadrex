package Aplicacao;
/*
    Jeferson created on 16/06/2020
*/

import xadrez.Cor;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;
import xadrez.XadrezException;


import java.util.Scanner;

public class UI {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";


    public static void limparTela(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void imprimirTabuleiro(PecaXadrez[][] pecas){
        for (int i = 0; i < pecas.length; i++){
            System.out.print((8 - i) + " ");
            for (int j = 0; j<pecas.length; j++){
                imprimirPeca(pecas[i][j], j,i, false);
            }
            System.out.println();
        }

        System.out.print(" A  B C  D  E F  G  H");
    }
    private static void imprimirPeca(PecaXadrez peca,int j,int i, boolean background){
        if(background){
            System.out.print(ANSI_BLUE_BACKGROUND );
        }
        if(peca == null){
            //linha Impar inicio Preto
            //Linha Par inicio Branco

            //Verifica se a linha é par
            //TODO Melhorar essa logica
            if(i % 2 == 0){
                if(j%2 == 0){
                    //Quadrado Petro Branco
                    System.out.print("\u25AC"+ ANSI_RESET);
                }else{

                    System.out.print("\u25AD"+ ANSI_RESET);
                }
                //Quadrado Branco Preto
            }else {
                if(j%2 == 0){
                    System.out.print("\u25AD"+ ANSI_RESET);
                }else {
                    System.out.print("\u25AC"+ ANSI_RESET);
                }
            }
        }else{
            if(peca.getCor() == Cor.BRANCO){
                System.out.print(ANSI_WHITE + peca + ANSI_RESET);
            }else{
                System.out.print(ANSI_BLACK + peca + ANSI_RESET);
            }

        }
        System.out.print(" ");

    }

    public static PosicaoXadrez lerPosicao(Scanner sc){
        //a1 a2 b1
        String s = sc.nextLine();
        //TODO validação do tamanho da String e da padrão dela.
        if(s.length() != 2){
            throw new XadrezException("Posição incorreta");
        }
        //pegar a primeira posição que indica a coluna
        char coluna = s.charAt(0);
        //pegar Segunda posição que indica a linha
        int linha = Integer.parseInt(s.substring(1));
        return new PosicaoXadrez(coluna,linha);
    }

    public static void imprimirTabuleiro(PecaXadrez[][] pecas, boolean[][] posiveisMovimentos) {
        for (int i = 0; i < pecas.length; i++){
            System.out.print((8 - i) + " ");
            for (int j = 0; j<pecas.length; j++){
                imprimirPeca(pecas[i][j], j,i, posiveisMovimentos[i][j]);
            }
            System.out.println();
        }
        System.out.print(" A  B C  D  E F  G  H");
    }
}
