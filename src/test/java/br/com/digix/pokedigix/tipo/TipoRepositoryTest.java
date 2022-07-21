package br.com.digix.pokedigix.tipo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class TipoRepositoryTest {

  @Autowired
  private TipoRepository tipoRepository;

  @Test
  public void deve_salvar_um_tipo() {
    // Arrange
    String nomeEsperado = "Água";
    Long idEsperado = 2L;
    //Act
    Tipo tipo = new Tipo(nomeEsperado);
    tipoRepository.save(tipo);
    //Assert
    assertEquals(idEsperado, tipo.getId());
  }
}
