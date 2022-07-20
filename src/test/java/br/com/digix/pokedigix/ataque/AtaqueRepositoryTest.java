package br.com.digix.pokedigix.ataque;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class AtaqueRepositoryTest {

@Autowired
  private AtaqueRepository ataqueRepository;

@Test
  public void deve_salvar_um_ataque() {
    // Arrange
    Long idEsperado = 1L;
    String nome = "Aqua Jet";
    double forca = 25;
    double acuracia = 90;
    String descricao = "Jato poderoso de água, que pode afogar os inimigos";
    double ponto_de_poder = 43;
    Categoria categoria = Categoria.FISICO;
    //Act
    Ataque ataque = new Ataque(descricao, ponto_de_poder, ponto_de_poder, descricao, ponto_de_poder, categoria);
    ataqueRepository.save(ataque);
    //Assert
    assertEquals(idEsperado, ataque.getId());
  }
}
