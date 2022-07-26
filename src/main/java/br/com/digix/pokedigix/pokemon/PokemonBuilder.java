package br.com.digix.pokedigix.pokemon;

import java.util.ArrayList;
import java.util.Collection;

import br.com.digix.pokedigix.ataque.Ataque;
import br.com.digix.pokedigix.tipo.Tipo;

public class PokemonBuilder {

    private Collection<Ataque> ataques;
    private String nome;
    private int altura;
    private int peso;
    private Genero genero;
    private int numeroPokedex;
    private int nivel;
    private int felicidade;
    Collection<Tipo> tipos;
    
    public PokemonBuilder(){
        this.nome = "Squirtle";
        this.altura = 44;
        this.peso = 3;
        this.genero = Genero.MASCULINO;
        this.numeroPokedex = 07;
        this.nivel = 15;
        this.felicidade = 150;
        this.tipos = new ArrayList<>();
        this.ataques = new ArrayList<>();
    }
    
    public PokemonBuilder comAtaque(Ataque ataque) {
        this.ataques.add(ataque);
        return this;
    }

    public Pokemon construir() {
        return new Pokemon(nome, altura, peso, genero, numeroPokedex, nivel, felicidade, tipos, ataques);
    }

    public PokemonBuilder comTipo(Tipo tipo) {
        this.tipos.add(tipo);
        return this;
    }
}
