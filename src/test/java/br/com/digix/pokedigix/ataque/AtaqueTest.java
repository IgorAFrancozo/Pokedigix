package br.com.digix.pokedigix.ataque;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AtaqueTest {

  @Test
  public void deve_verificar_ataque() {
    // Arrange
    String nomeEsperado = "Aqua Jet";
    String descricao = "Jato poderoso de água, que pode afogar os inimigos";
    //Act
    Ataque ataque = new Ataque(nomeEsperado, 0, 0, descricao, 0, null);
    //Assert
    assertEquals(nomeEsperado, ataque.getNome());
    assertEquals(descricao, ataque.getDescricao());
  }
}
