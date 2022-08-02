package br.com.digix.pokedigix.pokemon;

public class FelicidadeInvalidaException extends Exception{
    public FelicidadeInvalidaException(){
        super("O Pokemon não pode ter felicidade maior que cem e menor que zero");
    }
}
