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
public class GalpaoControllerMvc {

    @Autowired
    private GalpaoService galpaoService;

    // ✅ Listar todos os galpões (para a página galpoes.html)
    @GetMapping
    public String listarGalpoes(Model model) {
        List<GalpaoDTO> galpoes = galpaoService.listarTodos(); // cria esse método no service
        model.addAttribute("galpoes", galpoes);
        return "galpoes"; // nome do HTML em src/main/resources/templates
    }

    // ✅ Buscar por ID e exibir detalhes do galpão
    @GetMapping("/{id}")
    public String buscarGalpaoPorId(@PathVariable Long id, Model model) {
        GalpaoDTO galpao = galpaoService.buscarPorId(id) // cria esse método no service
                .orElseThrow(() -> new RuntimeException("Galpão não encontrado"));
        model.addAttribute("galpao", galpao);
        return "galpao-detalhe"; // página específica do galpão
    }

    // ✅ Exibir formulário para criar galpão
    @GetMapping("/novo")
    public String novoGalpaoForm(Model model) {
        model.addAttribute("galpao", new GalpaoDTO());
        return "galpao-form";
    }

    // ✅ Salvar galpão do formulário
    @PostMapping
    public String salvarGalpao(@ModelAttribute GalpaoDTO galpaoDTO) {
        galpaoService.saveFromDTO(galpaoDTO); // cria esse método no service
        return "redirect:/galpoes";
    }
}
