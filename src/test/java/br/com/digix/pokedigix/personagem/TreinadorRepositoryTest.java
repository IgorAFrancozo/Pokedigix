package br.com.digix.pokedigix.personagem;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class TreinadorRepositoryTest {

    @Autowired
    private TreinadorRepository treinadorRepository;

    @Test
    public void deve_salvar_um_treinador(){
        //Arrange
        Treinador treinador = new TreinadorBuilder().construir();
        //Act
        treinadorRepository.save(treinador);
        //Assert
        assertNotNull(treinador.getId());
    }
}
