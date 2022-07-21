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
    String nomeEsperado = "Aqua Jet";
    double forcaEsperada = 25;
    double acuraciaEsperada = 90;
    String descricaoEsperada = "Jato poderoso de água, que pode afogar os inimigos";
    double ponto_de_poderEsperada = 43;
    Categoria categoria = Categoria.FISICO;
    //Act
    Ataque ataque = new Ataque(nomeEsperado, forcaEsperada, acuraciaEsperada, descricaoEsperada, ponto_de_poderEsperada, categoria);
    ataqueRepository.save(ataque);
    //Assert
    assertEquals(idEsperado, ataque.getId());
    assertEquals(nomeEsperado, ataque.getNome());
    assertEquals(forcaEsperada, ataque.getForca());
    assertEquals(acuraciaEsperada, ataque.getAcuracia());
    assertEquals(ponto_de_poderEsperada, ataque.getPonto_de_poder());
  }
}
