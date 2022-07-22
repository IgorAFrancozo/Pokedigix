package br.com.digix.pokedigix.treinador;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Treinador {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  String nome;
  double dinheiro;
  double nivel;

  public Treinador(String nome, double dinheiro, double nivel) {
    this.nome = nome;
    this.dinheiro = dinheiro;
    this.nivel = nivel;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public double getDinheiro() {
    return dinheiro;
  }

  public void setDinheiro(double dinheiro) {
    this.dinheiro = dinheiro;
  }

  public double getNivel() {
    return nivel;
  }

  public void setNivel(double nivel) {
    this.nivel = nivel;
  }

  public Long getId() {
    return this.id;
  }
}
