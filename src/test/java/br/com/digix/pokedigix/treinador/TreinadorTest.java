package br.com.digix.pokedigix.treinador;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TreinadorTest {
    @Test
    public void deve_poder_criar_um_treinador() {
        // Arrange
        String nome = "Winchester";
        double dinheiro = 1000;
        double nivel = 12;

        // Act
        var treinador = new Treinador(nome, dinheiro, nivel);

        // Assert
        assertEquals(nome, treinador.getNome());
        assertEquals(dinheiro, treinador.getDinheiro());
        assertEquals(nivel, treinador.getNivel());
    }
}