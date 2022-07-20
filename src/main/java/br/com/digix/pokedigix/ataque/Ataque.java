package br.com.digix.pokedigix.ataque;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ataque {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable = false, length = 30)
  private String nome;

  private double forca;

  @Column(nullable = false)
  private double acuracia;

  @Column(nullable = false)
  private String descricao;

  @Column(nullable = false)
  private double ponto_de_poder;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Categoria categoria;

  public Ataque(
    String nome,
    double forca,
    double acuracia,
    String descricao,
    double ponto_de_poder,
    Categoria categoria
  ) {
    this.nome = nome;
    this.forca = forca;
    this.acuracia = acuracia;
    this.descricao = descricao;
    this.ponto_de_poder = ponto_de_poder;
    this.categoria = categoria;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String ataque) {
    this.nome = ataque;
  }

  public double getForca() {
    return forca;
  }

  public void setForca(double forca) {
    this.forca = forca;
  }

  public double getAcuracia() {
    return acuracia;
  }

  public void setAcuracia(double acuracia) {
    this.acuracia = acuracia;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public double getPonto_de_poder() {
    return ponto_de_poder;
  }

  public void setPonto_de_poder(double ponto_de_poder) {
    this.ponto_de_poder = ponto_de_poder;
  }

  public Long getId() {
    return this.id;
  }
}
