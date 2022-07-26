package br.com.digix.pokedigix.pokemon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.digix.pokedigix.ataque.Ataque;
import br.com.digix.pokedigix.ataque.AtaqueBuilder;
import br.com.digix.pokedigix.tipo.Tipo;

@DataJpaTest
public class PokemonRepositoryTest {

  @Autowired
  private PokemonRepository pokemonRepository;

  /**
   * @throws NivelInvalidoException
   * @throws FelicidadeInvalidaException
   */
  @Test
  public void deve_salvar_um_pokemon() throws NivelInvalidoException, FelicidadeInvalidaException {
    List<Tipo> tipos = new ArrayList<>();
    tipos.add(new Tipo("Água"));

    // Act
    Pokemon squirtle = new PokemonBuilder().construir();

    pokemonRepository.save(squirtle);

    assertNotNull(squirtle.getId());
  }

  @Test
  public void deve_salvar_um_pokemon_com_um_tipo() throws NivelInvalidoException, FelicidadeInvalidaException {
    int quantidadeDeTiposEsperada = 1;
    List<Tipo> tipos = new ArrayList<>();
    Tipo agua = new Tipo("Água");
    tipos.add(agua);

    // Act
    Pokemon squirtle = new PokemonBuilder().comTipo(agua).construir();

    pokemonRepository.save(squirtle);

    Pokemon squirtleRetornado = pokemonRepository
      .findById(squirtle.getId())
      .get();

    assertNotNull(squirtleRetornado.getTipos());
    assertEquals(quantidadeDeTiposEsperada, squirtleRetornado.getTipos().size());
    assertTrue(squirtleRetornado.getTipos().contains(agua));
  }

  @Test
  public void deve_salvar_um_pokemon_com_ataque() throws Exception {
    Ataque ataque = new AtaqueBuilder().construir();
    Pokemon pokemon = new PokemonBuilder().comAtaque(ataque).construir();
    
    pokemonRepository.save(pokemon);

    assertTrue(pokemon.getAtaques().contains(ataque));
  }
}
