package br.com.digix.pokedigix.pokemon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import br.com.digix.pokedigix.tipo.Tipo;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class PokemonTest {

  @Test
  public void deve_poder_criar_um_pokemon()
    throws NivelInvalidoException, FelicidadeInvalidaException {
    // Arrange
    String nome = "Squirtle";
    double altura = 44;
    double peso = 3;
    Genero genero = Genero.MASCULINO;
    int numeroPokedex = 07;
    int nivel = 15;
    int felicidade = 80;
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
  public void deve_cadastrar_um_tipo_para_o_pokemon()
    throws NivelInvalidoException, FelicidadeInvalidaException {
    Tipo tipo = new Tipo("Água");

    Pokemon squirtle = new PokemonBuilder().comTipo(tipo).construir();

    assertTrue(squirtle.getTipos().contains(tipo));
  }

  @Test
  public void deve_ter_nivel_minimo_um() throws Exception {
    int nivelMinimo = 1;
    Pokemon pokemon = new PokemonBuilder().comNivel(nivelMinimo).construir();
    assertEquals(nivelMinimo, pokemon.getNivel());
  }

  @Test
  public void deve_ter_o_nivel_maximo_cem() throws Exception {
    int nivelMaximo = 100;
    Pokemon pokemon = new PokemonBuilder().comNivel(nivelMaximo).construir();
    assertEquals(nivelMaximo, pokemon.getNivel());
  }

  @Test
  public void nivel_nao_pode_ser_menor_que_um() {
    //Arrange
    int nivelProibido = -1;

    assertThrows(
      NivelInvalidoException.class,
      () -> {
        new PokemonBuilder().comNivelInvalido(nivelProibido).construir();
      }
    );
  }

  @Test
  public void nivel_nao_pode_ser_maior_que_cem() {
    //Arrange
    int nivelProibido = 101;

    assertThrows(
      NivelInvalidoException.class,
      () -> {
        new PokemonBuilder().comNivelInvalido(nivelProibido).construir();
      }
    );
  }

  @Test
  public void deve_ter_felicidade_minima_zero()
    throws NivelInvalidoException, FelicidadeInvalidaException {
    int felicidadeMinima = 1;
    Pokemon pokemon = new PokemonBuilder()
      .comFelicidade(felicidadeMinima)
      .construir();

    assertEquals(felicidadeMinima, pokemon.getFelicidade());
  }

  @Test
  public void deve_ter_felicidade_maxima_cem()
    throws NivelInvalidoException, FelicidadeInvalidaException {
    int felicidadeMaxima = 100;
    Pokemon pokemon = new PokemonBuilder()
      .comFelicidade(felicidadeMaxima)
      .construir();

    assertEquals(felicidadeMaxima, pokemon.getFelicidade());
  }

  @Test
  public void nao_deve_ter_felicidade_menor_que_zero() {
    int felicidadeInvalida = -1;

    assertThrows(
      FelicidadeInvalidaException.class,
      () -> {
        new PokemonBuilder().comFelicidade(felicidadeInvalida).construir();
      }
    );
  }

  @Test
  public void nao_deve_ter_felicidade_maior_que_cem() {
    int felicidadeInvalida = -1;

    assertThrows(
      FelicidadeInvalidaException.class,
      () -> {
        new PokemonBuilder().comFelicidade(felicidadeInvalida).construir();
      }
    );
  }
}
