package br.com.digix.pokedigix.pokemon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PokemonTest {

    @Test
    public void deve_poder_criar_um_pokemon() {
        // Arrange
        String nome = "Squirtle";
        int altura = 44;
        int peso = 3;
        String genero = "M";
        int numeroPokedex = 07;
        int nivel = 15;
        int felicidade = 150;

        // Act
        Pokemon pokemon = new Pokemon(nome, altura, peso, genero, numeroPokedex, nivel, felicidade);

        // Assert
        assertEquals(nome, pokemon.getNome());
        assertEquals(nivel, pokemon.getNivel());
        assertEquals(felicidade, pokemon.getFelicidade());
        assertEquals(altura, pokemon.getAltura());
        assertEquals(peso, pokemon.getPeso());
        assertEquals(genero, pokemon.getGenero());
        assertEquals(numeroPokedex, pokemon.getNumero_pokedex());
    }
}