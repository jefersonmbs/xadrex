package Aplicacao;

import xadrez.Partida;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;

import java.util.Scanner;

import static java.awt.event.KeyEvent.VK_SHIFT;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Partida partida = new Partida();


        while (true){
            UI.imprimirTabuleiro(partida.getPecas());
            System.out.println();
            System.out.print(" digite a posição da peça que deseja mover: ");
            PosicaoXadrez origen = UI.lerPosicao(sc);

            System.out.println();
            System.out.print(" digite a posição da peça que deseja ir: ");
            PosicaoXadrez futura = UI.lerPosicao(sc);

            PecaXadrez pecaXadrez = partida.moverPeca(origen,futura);
            // partida.moverPeca(origen,futura);
        }



    }
}
