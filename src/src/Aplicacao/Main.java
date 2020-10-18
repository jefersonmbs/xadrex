package Aplicacao;

/**
 * Created by Jeferson. 16/06/2020
 */

import xadrez.Partida;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;
import xadrez.XadrezException;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Partida partida = new Partida();


        while (true) {
            try {
                UI.limparTela();
                UI.imprimirTabuleiro(partida.getPecas());
                System.out.println();
                System.out.print(" digite a posição da peça que deseja mover: ");
                PosicaoXadrez origen = UI.lerPosicao(sc);

                System.out.println();
                System.out.print(" digite a posição da peça que deseja ir: ");
                PosicaoXadrez futura = UI.lerPosicao(sc);

                PecaXadrez pecaXadrez = partida.moverPeca(origen, futura);
                // partida.moverPeca(origen,futura);
            } catch (XadrezException | InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }


    }
}
