package br.com.digix.pokedigix.pokemon;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import br.com.digix.pokedigix.tipo.Tipo;

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
  double nivel;
  double felicidade;
  @ManyToMany
  private Collection<Tipo> tipos;

  public Pokemon(
    String nome,
    double altura,
    double peso,
    Genero genero,
    double numero_pokedex,
    double nivel,
    double felicidade,
    Collection<Tipo> tipos
  ) {
    this.nome = nome;
    this.altura = altura;
    this.peso = peso;
    this.genero = genero;
    this.numero_pokedex = numero_pokedex;
    this.nivel = nivel;
    this.felicidade = felicidade;
    this.tipos = tipos;
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

  public double getNivel() {
    return this.nivel;
  }

  public void setNivel(double nivel) {
    this.nivel = nivel;
  }

  public double getFelicidade() {
    return this.felicidade;
  }

  public void setFelicidade(double felicidade) {
    this.felicidade = felicidade;
  }

  public Collection<Tipo> getTipos() {
    return tipos;
  }
  public Collection<Tipo> setTipos() {
    return tipos;
  }

  public Long getId() {
    return this.id;
  }
}
