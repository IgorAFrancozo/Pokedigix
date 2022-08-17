package br.com.digix.pokedigix.tipo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;

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
    //Act
    Tipo tipo = new Tipo(nomeEsperado);
    tipoRepository.save(tipo);
    //Assert
    assertNotNull(tipo.getId());
  }

  @Test
  public void deve_buscar_um_tipo_pelo_nome() {
    String nome = "Água";
    Tipo tipoEsperado = new Tipo(nome);
    tipoRepository.save(tipoEsperado);

    Collection < Tipo > tiposRetornados = tipoRepository.findByNomeContaining(nome);

    assertTrue(tiposRetornados.contains(tipoEsperado));
  }

  @Test
  public void deve_remover_pelo_nome() {
    String fada = "Fairy";
    String fantasma = "Fantasma";
    tipoRepository.save(new Tipo(fada));
    tipoRepository.save(new Tipo(fantasma));
    String termo = "Fa";
    Long expected = 2l;

    Long quantidadeRemovida = tipoRepository.deleteByNomeContaining(termo);
    assertEquals(expected, quantidadeRemovida);
  }
}
