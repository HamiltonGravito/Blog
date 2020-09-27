package br.com.blog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.blog.model.Usuario;
import br.com.blog.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario salvarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public Usuario validarAcesso(String nome, String senha) {
		List<Usuario> listaDeUsuarios = usuarioRepository.findAll();
		Usuario usuario = null;
		for(Usuario usuarioLista : listaDeUsuarios) {
			if(usuarioLista.getNome().equals(nome) && usuarioLista.getSenha().equals(senha)) {
				usuario = usuarioLista;
				break;
			}
		}
		return usuario;
	}
	
	public Usuario buscarPorId(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.get();
	}
	
}
