package br.com.fiap.moop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.fiap.moop.DTO.GalpaoDTO;
import br.com.fiap.moop.model.Galpao;
import br.com.fiap.moop.service.GalpaoService;

@Controller
@RequestMapping("/galpoes")
public class GalpaoController {

    @Autowired
    private GalpaoService galpaoService;

    @PostMapping
    public ResponseEntity<GalpaoDTO> criarGalpao( @RequestBody GalpaoDTO galpaoDTO) {
        Galpao galpao = new Galpao();
        galpao.setLocalizacao(galpaoDTO.getLocalizacao());
        galpao.setCapacidade(galpaoDTO.getCapacidade());
        Galpao savedGalpao = galpaoService.save(galpao);
        return ResponseEntity.ok(new GalpaoDTO());
    }

    @GetMapping
    public Page<GalpaoDTO> listarGalpoes(Pageable pageable) {
        return galpaoService.findAll(pageable);
    }

    @GetMapping("/buscar")
    public Page<GalpaoDTO> buscarGalpoes(@RequestParam String localizacao, Pageable pageable) {
        return galpaoService.findByLocalizacao(localizacao, pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Galpao> buscarGalpaoPorId(@PathVariable Long id) {
        Galpao galpao = galpaoService.findById(id)
                .orElseThrow(() -> new RuntimeException("Galpão não encontrado"));
        return ResponseEntity.ok(galpao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GalpaoDTO> atualizarGalpao(@PathVariable Long id, @RequestBody GalpaoDTO galpaoDTO) {
        Galpao galpaoExistente = new Galpao();
        galpaoExistente.setId(id);
        galpaoExistente.setLocalizacao(galpaoDTO.getLocalizacao());
        galpaoExistente.setCapacidade(galpaoDTO.getCapacidade());
        Galpao updatedGalpao = galpaoService.update(id, galpaoExistente);
        return ResponseEntity.ok(new GalpaoDTO());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarGalpao(@PathVariable Long id) {
        galpaoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}