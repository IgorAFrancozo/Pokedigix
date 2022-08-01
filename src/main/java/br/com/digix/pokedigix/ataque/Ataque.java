package br.com.digix.pokedigix.ataque;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import br.com.digix.pokedigix.pokemon.Pokemon;
import br.com.digix.pokedigix.tipo.Tipo;

@Entity
public class Ataque {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable = false, length = 30)
  private String nome;

  private double forca;

  @Column(nullable = false)
  private double acuracia;

  @Column(nullable = false)
  private String descricao;

  @Column(nullable = false)
  private double ponto_de_poder;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Categoria categoria;

  @ManyToOne
  private Tipo tipo;

  @ManyToMany(mappedBy = "ataques")
  Collection <Pokemon> pokemons;

  
 
  public Ataque(
    String nome,
    double forca,
    double acuraciaEsperada,
    String descricao,
    double ponto_de_poder,
    Categoria categoria,
    Tipo tipo
  ) throws Exception {

    validarAcuracia(acuraciaEsperada);
    validarForca(categoria, forca);
    validarTipo(categoria, tipo);

    this.nome = nome;
    this.forca = forca;
    this.acuracia = acuraciaEsperada;
    this.descricao = descricao;
    this.ponto_de_poder = ponto_de_poder;
    this.categoria = categoria;
    this.tipo = tipo;
  }

  private void validarTipo(Categoria categoria, Tipo tipo) throws TipoInvalidoParaCategoriaException {
    if((categoria.equals(Categoria.FISICO) && tipo == null) || (categoria.equals(Categoria.ESPECIAL) && tipo == null)){
      throw new TipoInvalidoParaCategoriaException(tipo);
    }
  }
  private void validarForca(Categoria categoria, double forca) throws ForcaInvalidaParaCategoriaException {
    if((categoria.equals(Categoria.FISICO) && forca <= 0) || (categoria.equals(Categoria.ESPECIAL) && forca <= 0)){
      throw new ForcaInvalidaParaCategoriaException(categoria);
    }
  }

  private void validarAcuracia(double acuraciaEsperada) throws AcuraciaInvalidaException {
    if(acuraciaEsperada < 0 || acuraciaEsperada > 100){
    throw new AcuraciaInvalidaException();
    }
  }

  public Ataque(String nome, int acuracia, String descricao, int ponto_de_poder) {
    this.nome = nome;
    this.acuracia = acuracia;
    this.descricao = descricao;
    this.ponto_de_poder = ponto_de_poder;
    this.categoria = Categoria.EFEITO;
}

public Tipo getTipo() {
    return this.tipo;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String ataque) {
    this.nome = ataque;
  }

  public double getForca() {
    return forca;
  }

  public void setForca(double forca) {
    this.forca = forca;
  }

  public double getAcuracia() {
    return acuracia;
  }

  public void setAcuracia(double acuracia) {
    this.acuracia = acuracia;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public double getPonto_de_poder() {
    return ponto_de_poder;
  }

  public void setPonto_de_poder(double ponto_de_poder) {
    this.ponto_de_poder = ponto_de_poder;
  }
  
  public Collection<Pokemon> getPokemons() {
    return pokemons;
  }
  
    public Object getCategoria() {
      return this.categoria;
    }
  public Long getId() {
    return this.id;
  }
}
