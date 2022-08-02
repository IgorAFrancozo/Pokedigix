package br.com.digix.pokedigix.personagem;

import br.com.digix.pokedigix.pokemon.FelicidadeInvalidaException;
import br.com.digix.pokedigix.pokemon.NivelInvalidoException;
import br.com.digix.pokedigix.pokemon.Pokemon;
import br.com.digix.pokedigix.pokemon.PokemonBuilder;

public class TreinadorBuilder {

  private String nome;
  private Endereco endereco;
  private Pokemon pokemon;

  public TreinadorBuilder() throws NivelInvalidoException, FelicidadeInvalidaException {
    this.nome = "Winchester";
    this.endereco = new EnderecoBuilder().construir();
    this.pokemon = new PokemonBuilder().construir();
  }

  public Treinador construir() throws Exception {
    return new Treinador(nome, endereco, pokemon);
  }

  public TreinadorBuilder comPokemonInicial(Pokemon pokemonInicial) {
    this.pokemon = pokemonInicial;
    return this;
  }
}
