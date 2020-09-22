package br.com.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.blog.model.Comentario;
import br.com.blog.repository.ComentarioRepository;

@Service
public class ComentarioService {

	@Autowired
	private ComentarioRepository comentarioRepository;
	
	public Comentario salvarComentario(Comentario comentario) {
		return comentarioRepository.save(comentario);
	}
	
	public void excluirComentario(Long id) {
		comentarioRepository.deleteById(id);
	}
}
