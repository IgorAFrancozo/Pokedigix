package br.com.digix.pokedigix.ataque;

import br.com.digix.pokedigix.tipo.Tipo;

public class AtaqueBuilder {

  private int forca;
  private int acuracia;
  private String nome;
  private String descricao;
  private int ponto_de_poder;
  private Categoria categoria;
  private Tipo tipoEsperado;

  public AtaqueBuilder() {
    this.nome = "AquaJet";
    this.forca = 20;
    this.acuracia = 88;
    this.descricao = "Jato poderoso de água, que pode afogar os inimigos";
    this.ponto_de_poder = 25;
    this.categoria = Categoria.FISICO;
    this.tipoEsperado = new Tipo("Água");
  }

  public AtaqueBuilder comTipo(Tipo tipoEsperado) {
    this.tipoEsperado = tipoEsperado;
    return this;
  }

  public Ataque construir() throws Exception {
    if (this.categoria.equals(Categoria.EFEITO)) {
      return new Ataque(nome, acuracia, descricao, ponto_de_poder);
    } else {
      return new Ataque(
        nome,
        forca,
        acuracia,
        descricao,
        ponto_de_poder,
        categoria,
        tipoEsperado
      );
    }
  }

  public AtaqueBuilder comAcuracia(int acuracia) {
    this.acuracia = acuracia;
    return this;
  }

  public AtaqueBuilder comCategoriaEfeito() {
    this.categoria = Categoria.EFEITO;
    return this;
  }

  public AtaqueBuilder comForca(int forca) {
    this.forca = forca;
    return this;
  }

  public AtaqueBuilder comCategoria(Categoria categoria) {
    this.categoria = categoria;
    return this;
  }
}
