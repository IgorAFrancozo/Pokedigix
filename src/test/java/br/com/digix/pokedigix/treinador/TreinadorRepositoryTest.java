package br.com.digix.pokedigix.treinador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import br.com.digix.pokedigix.tipo.Tipo;
import br.com.digix.pokedigix.tipo.TipoRepository;
import java.util.Collection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class TreinadorRepositoryTest {

  @Autowired
  private TreinadorRepository treinadorRepository;

  @Test
  public void deve_salvar_um_treinador() {
    String nome = "Winchester";
    double dinheiro = 1000;
    double nivel = 12;

    var treinador = new Treinador(nome, dinheiro, nivel);

    treinadorRepository.save(treinador);

    assertNotNull(treinador.getId());
  }

}
