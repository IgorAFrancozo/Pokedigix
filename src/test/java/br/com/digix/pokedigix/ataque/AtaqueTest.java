package br.com.digix.pokedigix.ataque;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.digix.pokedigix.tipo.Tipo;

public class AtaqueTest {

  @Test
  public void deve_verificar_ataque() {
    // Arrange
    String nomeEsperado = "Aqua Jet";
    String descricao = "Jato poderoso de água, que pode afogar os inimigos";
    //Act
    Ataque ataque = new Ataque(nomeEsperado, 0, 0, descricao, 0, null, null);
    //Assert
    assertEquals(nomeEsperado, ataque.getNome());
    assertEquals(descricao, ataque.getDescricao());
  }

  @Test
  public void deve_ser_obrigatorio_informar_um_tipo(){
    int forca = 20;
    int acuracia = 88;
    String descricao = "Jato poderoso de água, que pode afogar os inimigos";
    int ponto_de_poder = 25;
    Categoria categoria = Categoria.FISICO;
    Tipo tipoEsperado = new Tipo("Fantasma");

    Ataque ataque = new Ataque(descricao, forca, acuracia, descricao, ponto_de_poder, categoria, tipoEsperado);
  
    assertEquals(tipoEsperado, ataque.getTipo());
  }
  
}
