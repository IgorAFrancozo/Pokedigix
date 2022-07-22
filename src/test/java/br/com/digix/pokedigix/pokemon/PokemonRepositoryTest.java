package br.com.digix.pokedigix.pokemon;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class PokemonRepositoryTest {
    
    @Autowired
    private PokemonRepository pokemonRepository;

    @Test
    public void deve_salvar_um_pokemon(){
        String nome = "Squirtle";
        int altura = 44;
        int peso = 3;
        String genero = "M";
        int numeroPokedex = 07;
        int nivel = 15;
        int felicidade = 150;

        // Act
        Pokemon pokemon = new Pokemon(nome, altura, peso, genero, numeroPokedex, nivel, felicidade);

        pokemonRepository.save(pokemon);

        assertNotNull(pokemon.getId());
    }
}