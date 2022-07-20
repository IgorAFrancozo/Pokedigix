package br.com.digix.pokedigix.pokemon;

public class Pokemon {
    String nome;
    double altura;
    double peso;
    String genero;
    double numero_pokedex;
    double id_treinador;
    
    public Pokemon(String nome, double altura, double peso, String genero, double numero_pokedex, double id_treinador) {
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.genero = genero;
        this.numero_pokedex = numero_pokedex;
        this.id_treinador = id_treinador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getNumero_pokedex() {
        return numero_pokedex;
    }

    public void setNumero_pokedex(double numero_pokedex) {
        this.numero_pokedex = numero_pokedex;
    }

    public double getId_treinador() {
        return id_treinador;
    }

    public void setId_treinador(double id_treinador) {
        this.id_treinador = id_treinador;
    }
}
