package br.com.digix.pokedigix.pokemon;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.digix.pokedigix.tipo.Tipo;

@DataJpaTest
public class PokemonRepositoryTest {
    
    @Autowired
    private PokemonRepository pokemonRepository;

    @Test
    public void deve_salvar_um_pokemon(){
        String nome = "Squirtle";
        int altura = 44;
        int peso = 3;
        Genero genero = Genero.MASCULINO;
        int numeroPokedex = 07;
        int nivel = 15;
        int felicidade = 150;
        List<Tipo> tipos = new ArrayList<>();
        tipos.add(new Tipo("Água"));

        // Act
        Pokemon squirtle = new Pokemon(nome, altura, peso, genero, numeroPokedex, nivel, felicidade, tipos);

        pokemonRepository.save(squirtle);

        assertNotNull(squirtle.getId());
    }
}