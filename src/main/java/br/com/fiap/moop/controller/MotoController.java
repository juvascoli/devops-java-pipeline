package br.com.fiap.moop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.moop.model.Galpao;
import br.com.fiap.moop.model.Moto;
import br.com.fiap.moop.model.Usuario;
import br.com.fiap.moop.repository.GalpaoRepository;
import br.com.fiap.moop.repository.MotoRepository;
import br.com.fiap.moop.repository.UsuarioRepository;
import br.com.fiap.moop.service.MotoService;

@Controller
@RequestMapping("/motos")
public class MotoController {

    @Autowired
    private MotoService motoService;
    @Autowired
	private MotoRepository repM;
    @Autowired
	private UsuarioRepository repU;
    
    @Autowired
    private GalpaoRepository repG;
    
    @GetMapping("/index")
    public ModelAndView popularIndex() {
        ModelAndView mv = new ModelAndView("motos/index");

        List<Moto> motos = repM.findAll();
        List<Galpao> galpoes = repG.findAll();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Optional<Usuario> op = repU.findByUsername(auth.getName());

        if (op.isPresent()) {
            mv.addObject("usuario", op.get());
        }

        mv.addObject("motos", motos);
        mv.addObject("galpoes", galpoes);

        return mv;
    }

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