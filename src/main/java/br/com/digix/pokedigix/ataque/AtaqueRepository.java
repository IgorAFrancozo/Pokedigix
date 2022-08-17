package br.com.digix.pokedigix.ataque;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface AtaqueRepository extends CrudRepository<Ataque, Long> {
  Collection<Ataque> findByNomeContaining(String nome);
  Long deleteByNomeContaining(String nome);
}
