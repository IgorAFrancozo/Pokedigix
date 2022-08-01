package br.com.digix.pokedigix.ataque;

import br.com.digix.pokedigix.tipo.Tipo;

public class TipoInvalidoParaCategoriaException extends Exception {
    public TipoInvalidoParaCategoriaException(Tipo tipo){
        super("O ataque de Categoria física precisa ter um tipo.");
    }
}
