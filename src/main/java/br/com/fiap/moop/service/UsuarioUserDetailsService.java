package br.com.fiap.moop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.fiap.moop.model.Usuario;
import br.com.fiap.moop.repository.UsuarioRepository;

@Service
public class UsuarioUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository repU;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = repU.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado!") );
		
		return User.withUsername(usuario.getUsername())
		        .password(usuario.getSenha())
		        .roles(usuario.getRole()) // ou usuario.getRole()
		        .build();
		
	}

}
