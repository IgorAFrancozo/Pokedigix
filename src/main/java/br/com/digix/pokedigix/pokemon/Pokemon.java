package br.com.digix.pokedigix.pokemon;

import br.com.digix.pokedigix.ataque.Ataque;
import br.com.digix.pokedigix.tipo.Tipo;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Pokemon {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable = false, length = 20)
  String nome;

  @Column(nullable = false)
  double altura;

  @Column(nullable = false)
  double peso;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false, length = 10)
  Genero genero;

  @Column(nullable = false)
  double numero_pokedex;

  @Column(nullable = false)
  int nivel;

  int felicidade;

  @ManyToMany(cascade = CascadeType.PERSIST)
  @JoinTable(
    name = "pokemon_tipo",
    joinColumns = @JoinColumn(name = "pokemon_id"),
    inverseJoinColumns = @JoinColumn(name = "tipo_id")
  )
  private Collection<Tipo> tipos;

  @ManyToMany(cascade = CascadeType.PERSIST)
  @JoinTable(
    name = "pokemon_ataque",
    joinColumns = @JoinColumn(name = "pokemon_id"),
    inverseJoinColumns = @JoinColumn(name = "ataque_id")
  )
  private Collection<Ataque> ataques;

  public Pokemon(
    String nome,
    double altura,
    double peso,
    Genero genero,
    double numero_pokedex,
    int nivel,
    int felicidade,
    Collection<Tipo> tipos,
    Collection<Ataque> ataques
  ) throws NivelInvalidoException, FelicidadeInvalidaException {
    this.nome = nome;
    this.altura = altura;
    this.peso = peso;
    this.genero = genero;
    this.numero_pokedex = numero_pokedex;
    this.nivel = nivel;
    this.felicidade = felicidade;
    this.tipos = tipos;
    this.ataques = ataques;
    comNivelInvalido(nivel);
    comFelicidade(felicidade);
  }

  public String getNome() {
    return nome;
  }
  
  public void setNome(String nome) {
    this.nome = nome;
  }
  
  public double getAltura() {
    return altura;
  }
  
  public void setAltura(double altura) {
    this.altura = altura;
  }
  
  public double getPeso() {
    return peso;
  }
  
  public void setPeso(double peso) {
    this.peso = peso;
  }
  
  public Genero getGenero(Genero genero) {
    return this.genero;
  }
  
  public void setGenero(Genero genero) {
    this.genero = genero;
  }
  
  public double getNumero_pokedex() {
    return numero_pokedex;
  }
  
  public void setNumero_pokedex(double numero_pokedex) {
    this.numero_pokedex = numero_pokedex;
  }
  
  public int getNivel() {
    return this.nivel;
  }

  public void setNivel(int nivel) {
    this.nivel = nivel;
  }
  
  public int getFelicidade() {
    return this.felicidade;
  }

  public void setFelicidade(int felicidade) {
    this.felicidade = felicidade;
  }
  
  public Collection<Tipo> getTipos() {
    return tipos;
  }

  public Collection<Tipo> setTipos() {
    return tipos;
  }

  public Collection<Ataque> getAtaques() {
    return ataques;
  }

  public Long getId() {
    return this.id;
  }
  private void comNivelInvalido(int nivelProibido) throws NivelInvalidoException {
    if(nivelProibido < 1 || nivelProibido > 100){
    throw new NivelInvalidoException();
    }
  }
  private void comFelicidade(int felicidade) throws FelicidadeInvalidaException {
    if(felicidade < 0 || felicidade > 100){
    throw new FelicidadeInvalidaException();
    }
  }
}
