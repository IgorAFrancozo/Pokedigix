package br.com.digix.pokedigix.ataque;

public class AcuraciaInvalidaException extends Exception{
    public AcuraciaInvalidaException() {
        super("A acuracia deve ser igual ou maior a zero e igual ou menor que 100.");
    }

}
