package br.com.digix.pokedigix.tipo;

import br.com.digix.pokedigix.pokemon.Pokemon;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tipo {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable = false, length = 15)
  private String nome;

  @ManyToMany(mappedBy = "tipos")
  private Collection<Pokemon> pokemons;

  protected Tipo() {}

  public Tipo(String nomeEsperado) {
    this.nome = nomeEsperado;
  }

  public String getNome() {
    return this.nome;
  }

  public Collection<Pokemon> getPokemon() {
    return pokemons;
  }

  public Collection<Pokemon> setPokemon() {
    return pokemons;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}
