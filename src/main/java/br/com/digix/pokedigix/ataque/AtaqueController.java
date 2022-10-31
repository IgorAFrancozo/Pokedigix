package br.com.digix.pokedigix.ataque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.digix.pokedigix.tipo.Tipo;
import br.com.digix.pokedigix.tipo.TipoRepository;
import br.com.digix.pokedigix.tipo.TipoResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping(path = { "/api/v1/ataques" }, produces = { "application/json" })
public class AtaqueController {

  @Autowired
  private AtaqueRepository ataqueRepository;
  @Autowired
  private TipoRepository TipoRepository;

  @Operation(summary = "Buscar todos os ataques pelo id")
  @ApiResponse(
    responseCode = "200",
    description = "Retorna os dados dos ataques cadastrados"
  )
  @GetMapping(path = "/{id}")
  public ResponseEntity<AtaqueResponseDTO> buscarPorId(@PathVariable Long id) {
    Ataque ataque = ataqueRepository.findById(id).get();
    TipoResponseDTO tipoResponseDTO = new TipoResponseDTO(
      ataque.getTipo().getId(),
      ataque.getTipo().getNome()
    );
    return ResponseEntity.ok(
      new AtaqueResponseDTO(
        ataque.getId(),
        ataque.getNome(),
        ataque.getForca(),
        ataque.getAcuracia(),
        ataque.getDescricao(),
        ataque.getPonto_de_poder(),
        ataque.getCategoria(),
        tipoResponseDTO
      )
    );
  }

  @Operation(summary = "Criar um novo Ataque que pode ser usado para Pokemons")
  @ApiResponse(
    responseCode = "201",
    description = "Ataque criado usando o Tipo"
  )
  @PostMapping(consumes = { "application/json" })
  public ResponseEntity<AtaqueResponseDTO> criarAtaque(
    @RequestBody AtaqueRequestDTO ataqueRequestDTO
  ) throws Exception {
    Tipo tipo = TipoRepository.findById(ataqueRequestDTO.getTipoId()).get();
    Ataque ataque;
    try {
      ataque =
        new Ataque(
          ataqueRequestDTO.getNome(),
          ataqueRequestDTO.getAcuracia(),
          ataqueRequestDTO.getForca(),
          ataqueRequestDTO.getDescricao(),
          ataqueRequestDTO.getPonto_de_poder(),
          ataqueRequestDTO.getCategoria(),
          tipo
        );
      ataqueRepository.save(ataque);
    } catch (AcuraciaInvalidaException | ForcaInvalidaParaCategoriaException | TipoInvalidoParaCategoriaException e) {
      return ResponseEntity.internalServerError().build();
    }

    TipoResponseDTO tipoResponseDTO = new TipoResponseDTO(
      tipo.getId(),
      tipo.getNome()
    );
    return ResponseEntity
      .status(HttpStatus.CREATED)
      .body(
        new AtaqueResponseDTO(
          ataque.getId(),
          ataque.getNome(),
          ataque.getForca(),
          ataque.getAcuracia(),
          ataque.getDescricao(),
          ataque.getPonto_de_poder(),
          ataque.getCategoria(),
          tipoResponseDTO
        )
      );
  }

  @Operation(summary = "Altera um tipo de ataque")
  @ApiResponse(responseCode = "200")
  @PutMapping(consumes = { "application/json" }, path = { "/{id}" })
  public ResponseEntity<AtaqueResponseDTO> alterarTipo(
    @RequestBody AtaqueRequestDTO ataqueRequestDTO,
    @PathVariable Long id
  ) {
    Ataque ataque = ataqueRepository.findById(id).get();
    TipoResponseDTO tipo = new TipoResponseDTO(
      ataque.getTipo().getId(),
      ataque.getTipo().getNome()
    );

    ataque.setNome(ataqueRequestDTO.getNome());
    ataque.setAcuracia(ataqueRequestDTO.getAcuracia());
    ataque.setDescricao(ataqueRequestDTO.getDescricao());
    ataque.setCategoriaAtaque(ataqueRequestDTO.getCategoria());
    ataque.setPonto_de_poder(ataqueRequestDTO.getPonto_de_poder());
    ataqueRepository.save(ataque);

    return ResponseEntity.ok(
      new AtaqueResponseDTO(
        ataque.getId(),
        ataque.getNome(),
        ataque.getForca(),
        ataque.getAcuracia(),
        ataque.getDescricao(),
        ataque.getPonto_de_poder(),
        ataque.getCategoria(),
        tipo
      )
    );
  }
}
