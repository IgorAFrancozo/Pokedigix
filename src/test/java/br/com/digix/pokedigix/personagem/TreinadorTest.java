package br.com.digix.pokedigix.personagem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.com.digix.pokedigix.pokemon.NivelInvalidoException;
import br.com.digix.pokedigix.pokemon.Pokemon;
import br.com.digix.pokedigix.pokemon.PokemonBuilder;

public class TreinadorTest {

  @Test
  public void deve_comecar_com_um_pokemon() throws Exception {
    //Arrange
    int quantidadeDePokemonsEsperada = 1;
    Pokemon pokemonInicial = new PokemonBuilder().construir();
    //Action
    Treinador treinador = new TreinadorBuilder()
      .comPokemonInicial(pokemonInicial)
      .construir();
    //Assert
    assertTrue(treinador.getPokemons().contains(pokemonInicial));
    assertEquals(quantidadeDePokemonsEsperada, treinador.getPokemons().size());
  }

  @Test
  public void deve_poder_capturar_um_pokemon() throws Exception {
    //Arrange
    int quantidadeDePokemonsEsperada = 2;
    Pokemon pokemonACapturar = new PokemonBuilder().construir();
    Treinador treinador = new TreinadorBuilder().construir();
    //Action
    treinador.capturar(pokemonACapturar);
    //Assert
    assertTrue(treinador.getPokemons().contains(pokemonACapturar));
    assertEquals(quantidadeDePokemonsEsperada, treinador.getPokemons().size());
  }

  @Test
  public void deve_ter_no_maximo_seis_pokemons_capturados() throws Exception {
    //Arrange
    Treinador treinador = new TreinadorBuilder().construir();
    //Action
    for (int i = 1; i <= 5; i++) {
      treinador.capturar(new PokemonBuilder().construir());
    }
    //Assert
    assertThrows(
      LimiteDePokemonException.class,
      () -> {
        treinador.capturar(new PokemonBuilder().construir());
      }
    );
  }

  @Test
  public void deve_ter_ate_seis_pokemons() throws Exception {
    //Arrange
    int quantidadeDePokemonsEsperada = 6;
    Treinador treinador = new TreinadorBuilder().construir();
    //Action
    for (int i = 1; i <= 5; i++) {
      treinador.capturar(new PokemonBuilder().construir());
    }
    //Assert
    assertEquals(quantidadeDePokemonsEsperada, treinador.getPokemons().size());
  }

}
