package br.com.digix.pokedigix.pokemon;

public class NivelInvalidoException extends Exception{
    public NivelInvalidoException(){
        super("O Pokemon não pode ter nível menor que um ou maior que cem");
    }
}
