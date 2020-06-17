package Aplicacao;

import xadrez.Partida;

public class Main {
    public static void main(String[] args) {

        Partida partida = new Partida();
        UI.imprimirTabuleiro(partida.getPecas());


    }
}
