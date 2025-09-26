package br.com.fiap.moop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiap.moop.DTO.GalpaoDTO;
import br.com.fiap.moop.service.GalpaoService;

@Controller
@RequestMapping("/galpoes")
public class GalpaoController {

    @Autowired
    private GalpaoService galpaoService;

    // ✅ Listar todos os galpões (para a página galpoes.html)
    @GetMapping
    public String listarGalpoes(Model model) {
        List<GalpaoDTO> galpoes = galpaoService.listarTodos();
        model.addAttribute("galpoes", galpoes);
        return "galpoes/index"; 
    }

    // ✅ Buscar galpão por ID e exibir detalhes
    @GetMapping("/{id}")
    public String buscarGalpaoPorId(@PathVariable Long id, Model model) {
        GalpaoDTO galpao = galpaoService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Galpão não encontrado"));
        model.addAttribute("galpao", galpao);
        return "galpoes/index"; 
    }


    @GetMapping("/novo")
    public String novoGalpaoForm(Model model) {
        model.addAttribute("galpao", new GalpaoDTO());
        return "galpao-form";
    }


    @PostMapping
    public String salvarGalpao(@ModelAttribute GalpaoDTO galpaoDTO) {
        galpaoService.saveFromDTO(galpaoDTO);
        return "redirect:/galpoes";
    }


    @GetMapping("/editar/{id}")
    public String editarGalpaoForm(@PathVariable Long id, Model model) {
        GalpaoDTO galpao = galpaoService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Galpão não encontrado"));
        model.addAttribute("galpao", galpao);
        return "galpao-form"; 
    }

    @PostMapping("/editar/{id}")
    public String atualizarGalpao(@PathVariable Long id, @ModelAttribute GalpaoDTO galpaoDTO) {
        galpaoDTO.setId(id);
        galpaoService.saveFromDTO(galpaoDTO);
        return "redirect:/galpoes";
    }

    // ✅ Deletar galpão
    @GetMapping("/deletar/{id}")
    public String deletarGalpao(@PathVariable Long id) {
        galpaoService.deletarPorId(id);
        return "redirect:/galpoes";
    }
}
