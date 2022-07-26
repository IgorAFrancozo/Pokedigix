package br.com.digix.pokedigix.pokemon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.digix.pokedigix.ataque.Ataque;
import br.com.digix.pokedigix.tipo.Tipo;

public class PokemonTest {

    @Test
    public void deve_poder_criar_um_pokemon() {
        // Arrange
        String nome = "Squirtle";
        double altura = 44;
        double peso = 3;
        Genero genero = Genero.MASCULINO;
        int numeroPokedex = 07;
        int nivel = 15;
        int felicidade = 150;
        List<Tipo> tipos = new ArrayList<>();
        tipos.add(new Tipo("Água"));

        // Act
        Pokemon squirtle = new PokemonBuilder().construir();

        // Assert
        assertEquals(nome, squirtle.getNome());
        assertEquals(nivel, squirtle.getNivel());
        assertEquals(felicidade, squirtle.getFelicidade());
        assertEquals(altura, squirtle.getAltura());
        assertEquals(peso, squirtle.getPeso());
        assertEquals(genero, squirtle.getGenero(genero));
        assertEquals(numeroPokedex, squirtle.getNumero_pokedex());
    }

    @Test
    public void deve_cadastrar_um_tipo_para_o_pokemon(){
        Tipo tipo = new Tipo("Água");

        Pokemon squirtle = new PokemonBuilder().comTipo(tipo).construir();
    }
}