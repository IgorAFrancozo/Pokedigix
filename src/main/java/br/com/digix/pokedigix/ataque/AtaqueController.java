package br.com.digix.pokedigix.ataque;

import br.com.digix.pokedigix.tipo.TipoResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = { "/api/v1/ataques" }, produces = { "application/json" })
public class AtaqueController {

  @Autowired
  private AtaqueRepository ataqueRepository;

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
}
