package br.com.digix.pokedigix.ataque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import br.com.digix.pokedigix.tipo.Tipo;
import br.com.digix.pokedigix.tipo.TipoRepository;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class AtaqueRepositoryTest {

  @Autowired
  private AtaqueRepository ataqueRepository;

  @Autowired
  private TipoRepository tipoRepository;

  @Test
  public void deve_salvar_um_ataque() {
    // Arrange
    String nomeEsperado = "Aqua Jet";
    double forcaEsperada = 25;
    double acuraciaEsperada = 90;
    String descricaoEsperada =
      "Jato poderoso de água, que pode afogar os inimigos";
    double ponto_de_poderEsperada = 43;
    Categoria categoria = Categoria.FISICO;
    Tipo tipo = new Tipo("Fantasma");
    //Act
    Ataque ataque = new Ataque(
      nomeEsperado,
      forcaEsperada,
      acuraciaEsperada,
      descricaoEsperada,
      ponto_de_poderEsperada,
      categoria,
      tipo
    );
    ataqueRepository.save(ataque);
    //Assert
    assertNotNull(ataque.getId());
    assertEquals(nomeEsperado, ataque.getNome());
    assertEquals(forcaEsperada, ataque.getForca());
    assertEquals(acuraciaEsperada, ataque.getAcuracia());
    assertEquals(ponto_de_poderEsperada, ataque.getPonto_de_poder());
    assertEquals(tipo, ataque.getTipo());
  }

  @Test
  public void deve_salvar_um_tipo_para_um_ataque() {
    int forca = 20;
    int acuracia = 88;
    String descricao = "Jato poderoso de água, que pode afogar os inimigos";
    int ponto_de_poder = 25;
    Categoria categoria = Categoria.FISICO;
    Tipo tipoEsperado = new Tipo("Fantasma");

    Ataque ataque = new Ataque(
      descricao,
      forca,
      acuracia,
      descricao,
      ponto_de_poder,
      categoria,
      tipoEsperado
    );
    tipoRepository.save(tipoEsperado);
    ataqueRepository.save(ataque);

    Ataque ataqueRetornado = ataqueRepository.findById(ataque.getId()).get();

    assertEquals(tipoEsperado.getNome(), ataqueRetornado.getTipo().getNome());
    assertNotNull(ataqueRetornado.getTipo().getId());
  }

  @Test
  public void deve_buscar_um_ataque_pelo_tipo(){
    int forca = 20;
    int acuracia = 88;
    String descricao = "Jato poderoso de água, que pode afogar os inimigos";
    int ponto_de_poder = 25;
    Categoria categoria = Categoria.FISICO;
    Tipo tipoEsperado = new Tipo("Fantasma");

    Ataque ataque = new Ataque(
      descricao,
      forca,
      acuracia,
      descricao,
      ponto_de_poder,
      categoria,
      tipoEsperado
    );
    tipoRepository.save(tipoEsperado);
    ataqueRepository.save(ataque);

    
  }
}
