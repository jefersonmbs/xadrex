package xadrez;

/**
 * Created by Jeferson. 16/06/2020
 */

import tabuleiro.TabuleiroExeption;

public class XadrezException extends TabuleiroExeption {
    public XadrezException(String mensagem){
        super(mensagem);
    }
}
