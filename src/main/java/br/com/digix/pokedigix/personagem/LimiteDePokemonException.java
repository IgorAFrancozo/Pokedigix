package br.com.digix.pokedigix.personagem;

public class LimiteDePokemonException extends Exception{
    public LimiteDePokemonException(){
        super("Limite máximo de Pokemons para um treinador é 06(seis)!");
    }
}
