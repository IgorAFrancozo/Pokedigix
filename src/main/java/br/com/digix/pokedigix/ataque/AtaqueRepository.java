package br.com.digix.pokedigix.ataque;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import br.com.digix.pokedigix.tipo.Tipo;

public interface AtaqueRepository extends CrudRepository<Ataque, Long> {
  Collection<Ataque> findByNomeContaining(String nome);
  Collection<Ataque> findByTipo(Tipo tipo);
  Collection<Ataque> findByCategoria(String categoria);
  Long deleteByNomeContaining(String nome);
}
