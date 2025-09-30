package br.com.fiap.moop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiap.moop.DTO.GalpaoDTO;
import br.com.fiap.moop.service.GalpaoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/galpoes")
public class GalpaoController {

    @Autowired
    private GalpaoService galpaoService;

    // Lista de galpões
    @GetMapping("/index")
    public String listarGalpoes(Model model) {
        model.addAttribute("galpoes", galpaoService.listarTodos());
        return "galpoes/index";
    }
    
    
    // Página de detalhes
    @GetMapping("/detalhes/{id}")
    public String detalhesGalpao(@PathVariable Long id, Model model) {
        GalpaoDTO galpaoDTO = galpaoService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Galpão não encontrado"));
        model.addAttribute("galpao", galpaoDTO);
        return "galpoes/detalhes"; // nome do template de detalhes
    }

    // Página de criação
    @GetMapping("/novo")
    public String novoGalpao(Model model) {
        model.addAttribute("galpao", new GalpaoDTO());
        return "galpoes/form_galpao";
    }

    // Página de edição
    @GetMapping("/editar/{id}")
    public String editarGalpao(@PathVariable Long id, Model model) {
        GalpaoDTO galpaoDTO = galpaoService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Galpão não encontrado"));
        model.addAttribute("galpao", galpaoDTO);
        return "galpoes/edicao"; 
    }

    // Atualizar galpão com validação
    @PostMapping("/atualizar/{id}")
    public String atualizarGalpao(@PathVariable Long id,
                                  @Valid @ModelAttribute GalpaoDTO galpaoDTO,
                                  BindingResult result) {
        if (result.hasErrors()) {
            throw new IllegalArgumentException(result.getAllErrors().get(0).getDefaultMessage());
        }

        galpaoDTO.setId(id);
        galpaoService.saveFromDTO(galpaoDTO);
        return "redirect:/motos/index";
    }

 // Salvar galpão 
    @PostMapping("/salvar")
    public String salvarGalpao(@Valid @ModelAttribute GalpaoDTO galpaoDTO,
                               BindingResult result) {
        if (result.hasErrors()) {
            // Lança exceção capturada pelo ControllerAdvice
            throw new IllegalArgumentException(result.getAllErrors().get(0).getDefaultMessage());
        }

        galpaoService.saveFromDTO(galpaoDTO);
        return "redirect:/motos/index";
    }

    // Deletar
    @GetMapping("/deletar/{id}")
    public String deletarGalpao(@PathVariable Long id) {
        galpaoService.deletarPorId(id);
        return "redirect:/motos/index";
    }
}
