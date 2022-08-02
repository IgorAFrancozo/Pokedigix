package br.com.digix.pokedigix.ataque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import br.com.digix.pokedigix.tipo.Tipo;
import org.junit.jupiter.api.Test;

public class AtaqueTest {

  @Test
  public void deve_verificar_ataque() throws Exception {
    // Arrange
    String nomeEsperado = "AquaJet";
    String descricao = "Jato poderoso de água, que pode afogar os inimigos";
    //Act
    Ataque ataque = new AtaqueBuilder().construir();
    //Assert
    assertEquals(nomeEsperado, ataque.getNome());
    assertEquals(descricao, ataque.getDescricao());
  }

  @Test
  public void deve_ser_obrigatorio_informar_um_tipo()
    throws Exception {
    Tipo tipoEsperado = new Tipo("Água");

    Ataque ataque = new AtaqueBuilder().comTipo(tipoEsperado).construir();

    assertEquals(tipoEsperado, ataque.getTipo());
  }

  @Test
  public void nao_deve_ter_acuracia_menor_que_zero() {
    //Arrange
    int acuracia = -1;
    assertThrows(
      AcuraciaInvalidaException.class,
      () -> {
        new AtaqueBuilder().comAcuracia(acuracia).comAcuracia(acuracia).construir();
      }
    );
    //Assert
    assertThrows(
      AcuraciaInvalidaException.class,
      () -> {
        //Act
        new AtaqueBuilder().comAcuracia(acuracia).construir();
      }
    );
  }

  @Test
  public void nao_deve_ter_acuracia_maior_que_cem()
    throws AcuraciaInvalidaException {
    //Arrange
    int acuracia = 101;
    assertThrows(
      AcuraciaInvalidaException.class,
      () -> {
      new AtaqueBuilder().comAcuracia(acuracia).comAcuracia(acuracia).construir();
      }
    );
    //Assert
    assertThrows(
      AcuraciaInvalidaException.class,
      () -> {
        //Act
        new AtaqueBuilder().comAcuracia(acuracia).construir();
      }
    );
  }

  @Test
  public void deve_poder_ter_acuracia_igual_a_zero()
    throws Exception {
    int acuraciaEsperada = 0;

    Ataque ataque = new AtaqueBuilder()
      .comAcuracia(acuraciaEsperada)
      .construir();

    assertEquals(acuraciaEsperada, ataque.getAcuracia());
  }

  @Test
  public void nao_deve_ter_forca_nem_tipo_quando_a_categoria_for_efeito()
    throws Exception {
    Categoria categoria = Categoria.EFEITO;
    int forca = 0;
    Tipo tipo = null;

    Ataque ataque = new AtaqueBuilder()
      .comCategoriaEfeito()
      .construir();

    assertEquals(categoria, ataque.getCategoria());
    assertEquals(forca, ataque.getForca());
    assertEquals(tipo, ataque.getTipo());
  }

  @Test
  public void nao_deve_ter_ataque_do_tipo_fisico_sem_forca(){
    Categoria categoria = Categoria.FISICO;
    int forca = 0;

    assertThrows(ForcaInvalidaParaCategoriaException.class, () ->{
      new AtaqueBuilder().comForca(forca).comCategoria(categoria).construir();
    });
  }

  @Test
  public void nao_deve_ter_ataque_de_categoria_fisica_sem_tipo(){
    Categoria categoria = Categoria.FISICO;
    Tipo tipo = null;

    assertThrows(TipoInvalidoParaCategoriaException.class, () -> {
      new AtaqueBuilder().comTipo(tipo).comCategoria(categoria).construir();
    });
  }

  @Test
  public void nao_deve_ter_ataque_do_tipo_especial_sem_forca(){
    Categoria categoria = Categoria.ESPECIAL;
    int forca = 0;

    assertThrows(ForcaInvalidaParaCategoriaException.class, () ->{
      new AtaqueBuilder().comForca(forca).comCategoria(categoria).construir();
    });
  }

  @Test
  public void nao_deve_ter_ataque_de_categoria_especial_sem_tipo(){
    Categoria categoria = Categoria.ESPECIAL;
    Tipo tipo = null;

    assertThrows(TipoInvalidoParaCategoriaException.class, () -> {
      new AtaqueBuilder().comTipo(tipo).comCategoria(categoria).construir();
    });
  }
}
