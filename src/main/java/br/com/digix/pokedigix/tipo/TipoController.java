package br.com.digix.pokedigix.tipo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.ArrayList;
import java.util.Collection;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = { "/api/v1/tipos" }, produces = { "application/json" })
public class TipoController {

  @Autowired
  private TipoRepository TipoRepository;

  @Operation(
    summary = "Criar um novo tipo que pode ser usado para Pokemons ou Ataques"
  )
  @ApiResponse(responseCode = "201")
  @PostMapping(consumes = { "application/json" })
  public ResponseEntity<TipoResponseDTO> criarTipo(
    @RequestBody TipoRequestDTO novoTipo
  ) {
    Tipo tipo = new Tipo(novoTipo.getNome());
    TipoRepository.save(tipo);
    return ResponseEntity
      .status(HttpStatus.CREATED)
      .body(new TipoResponseDTO(tipo.getId(), tipo.getNome()));
  }

  @Operation(summary = "Buscar todos os tipos sem ordem")
  @ApiResponse(responseCode = "200", description = "Lista de tipos cadastrados")
  @GetMapping
  public ResponseEntity<Collection<TipoResponseDTO>> buscarTodos(
    @RequestParam(required = false, name = "termo") String nome
  ) {
    Iterable<Tipo> tipos;
    if (nome != null) {
      tipos = TipoRepository.findByNomeContaining(nome);
    } else {
      tipos = TipoRepository.findAll();
    }

    Collection<TipoResponseDTO> tiposRetornados = new ArrayList<>();
    for (Tipo tipo : tipos) {
      tiposRetornados.add(new TipoResponseDTO(tipo.getId(), tipo.getNome()));
    }
    return ResponseEntity.ok(tiposRetornados);
  }

  @Operation(
    summary = "Buscar um tipo cadastrado pelo id que pode ser usado para Pokemons ou Ataques"
  )
  @ApiResponse(responseCode = "200")
  @GetMapping(path = "/{id}")
  public ResponseEntity<TipoResponseDTO> buscarPorId(@PathVariable Long id) {
    Tipo tipo = TipoRepository.findById(id).get();
    return ResponseEntity
      .status(HttpStatus.OK)
      .body(new TipoResponseDTO(tipo.getId(), tipo.getNome()));
  }

  @Operation(summary = "Deletar um tipo cadastrado pelo id")
  @ApiResponse(responseCode = "204")
  @DeleteMapping(path = "/{id}")
  public ResponseEntity<?> deletarPost(@PathVariable Long id) {
    TipoRepository.deleteById(id);
    return ResponseEntity.noContent().build();
  }

  @Operation(
    summary = "Deletar um tipo cadastrado pelo nome parcial ou completo"
  )
  @ApiResponse(responseCode = "204")
  @DeleteMapping
  @Transactional
  public ResponseEntity<?> removerTipoPorNome(
    @RequestParam(required = true) String termo
  ) {
    TipoRepository.deleteByNomeContaining(termo);
    return ResponseEntity.noContent().build();
  }

  @Operation(summary = "Atualizar um tipo previamente cadastrado")
  @ApiResponse(responseCode = "200")
  @PutMapping(path = "/{id}", consumes = "application/json")
  public ResponseEntity<TipoResponseDTO> alterarTipo(
    @RequestBody TipoRequestDTO tipoRequestDTO,
    @PathVariable Long id
  ) {
    Tipo tipoAlterar = TipoRepository.findById(id).get();
    tipoAlterar.setNome(tipoRequestDTO.getNome());
    TipoRepository.save(tipoAlterar);
    return ResponseEntity
      .status(HttpStatus.OK)
      .body(new TipoResponseDTO(tipoAlterar.getId(), tipoAlterar.getNome()));
  }
}
