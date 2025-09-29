package br.com.fiap.moop.controller;

import br.com.fiap.moop.DTO.GalpaoDTO;
import br.com.fiap.moop.service.GalpaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    // Atualizar ou salvar (usa o mesmo saveFromDTO)
    @PostMapping("/atualizar/{id}")
    public String atualizarGalpao(@PathVariable Long id, @ModelAttribute GalpaoDTO galpaoDTO) {
        galpaoDTO.setId(id);
        galpaoService.saveFromDTO(galpaoDTO);
        return "redirect:/motos/index";
    }

    // Criar novo
    @PostMapping("/salvar")
    public String salvarGalpao(@ModelAttribute GalpaoDTO galpaoDTO) {
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
