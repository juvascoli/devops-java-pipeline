package br.com.fiap.moop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.moop.model.Usuario;
import br.com.fiap.moop.repository.UsuarioRepository;

@Controller
public class UsuarioControllerMvc {

	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private UsuarioRepository repU;

	@GetMapping("/login")
	public ModelAndView logar() {
		return new ModelAndView("/login");
	}

	@GetMapping("/usuario/novo")
	public ModelAndView retornarCadUsuario() {

		ModelAndView mv = new ModelAndView("/usuario/novo");

		mv.addObject("usuario", new Usuario());

		return mv;

	}

	@PostMapping("/insere_usuario")
	public ModelAndView inserirUsuario(Usuario usuario) {

		usuario.setSenha(encoder.encode(usuario.getSenha()));


		repU.save(usuario);

		return new ModelAndView("redirect:/index");

	}
	
	
	@GetMapping("/acesso_negado")
	public ModelAndView retornarPagAcessoNegado() {
		return new ModelAndView("/acesso_negado");
	}
	
	
	
}
