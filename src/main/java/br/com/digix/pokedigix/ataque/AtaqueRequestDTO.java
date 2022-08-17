package br.com.digix.pokedigix.ataque;

import br.com.digix.pokedigix.tipo.TipoResponseDTO;

public class AtaqueRequestDTO {

  private String nome;
  private double forca;
  private double acuracia;
  private String descricao;
  private double ponto_de_poder;
  private Categoria categoria;
  private Long tipoId;

  
  
  public AtaqueResponseDTO(String nome, double forca, double acuracia, String descricao, double ponto_de_poder, Categoria categoria, Long tipoId) {
    this.nome = nome;
    this.forca = forca;
    this.acuracia = acuracia;
    this.descricao = descricao;
    this.ponto_de_poder = ponto_de_poder;
    this.categoria = categoria;
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

public Long getTipoId() {
  return tipoId;
}

public void setTipoId(Long tipoId) {
  this.tipoId = tipoId;
}
}
