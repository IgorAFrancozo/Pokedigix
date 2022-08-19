package br.com.digix.pokedigix.ataque;

import br.com.digix.pokedigix.tipo.TipoResponseDTO;

public class AtaqueResponseDTO {

  private Long id;
  private String nome;
  private double forca;
  private double acuracia;
  private String descricao;
  private double ponto_de_poder;
  private Categoria categoria;
  private TipoResponseDTO tipo;

  public AtaqueResponseDTO(
    Long id,
    String nome,
    double d,
    double e,
    String string,
    double ponto_de_poder,
    Categoria categoria2, TipoResponseDTO tipo
  ) {
    this.id = id;
    this.nome = nome;
    this.forca = d;
    this.acuracia = e;
    this.descricao = string;
    this.ponto_de_poder = ponto_de_poder;
    this.categoria = categoria2;
    this.tipo = tipo;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public TipoResponseDTO getTipo() {
    return tipo;
  }

  public void setTipo(TipoResponseDTO tipo) {
    this.tipo = tipo;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
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

  public Categoria getCategoria() {
    return categoria;
  }

  public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
  }
}
