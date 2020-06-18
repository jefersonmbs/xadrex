package xadrez;

/*
    Jeferson created on 17/06/2020
*/

import tabuleiro.TabuleiroExeption;

public class XadrezException extends TabuleiroExeption {
    public XadrezException(String mensagem){
        super(mensagem);
    }
}
