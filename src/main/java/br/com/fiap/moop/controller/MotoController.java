package br.com.fiap.moop.controller;

import br.com.fiap.moop.model.Moto;
import br.com.fiap.moop.service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/motos")
public class MotoController {

    @Autowired
    private MotoService motoService;

    // Criar Moto
    @PostMapping
    public ResponseEntity<Moto> criarMoto( @RequestBody Moto moto) {
        Moto novaMoto = motoService.save(moto);
        return ResponseEntity.ok(novaMoto);
    }

    // Listar Todas as Motos
    @GetMapping
    public ResponseEntity<List<Moto>> listarTodasAsMotos() {
        List<Moto> motos = motoService.findAll();
        return ResponseEntity.ok(motos);
    }

    // Buscar Moto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Moto>> buscarMotoPorId(@PathVariable Long id) {
        Optional<Moto> moto = motoService.findById(id);
        return ResponseEntity.ok(moto);
    }

    // Buscar Motos por Placa
    @GetMapping("/buscarPorPlaca")
    public ResponseEntity<List<Moto>> buscarMotosPorPlaca(@RequestParam String placa) {
        List<Moto> motos = motoService.findByPlaca(placa);
        return ResponseEntity.ok(motos);
    }

    // Atualizar Moto
    @PutMapping("/{id}")
    public ResponseEntity<Moto> atualizarMoto(@PathVariable Long id, @RequestBody Moto motoDetalhes) {
        Moto motoAtualizada = motoService.update(id, motoDetalhes);
        return ResponseEntity.ok(motoAtualizada);
    }

    // Deletar Moto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMoto(@PathVariable Long id) {
        motoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}