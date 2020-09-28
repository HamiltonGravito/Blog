package br.com.blog.service;

import java.util.List;
import java.util.Optional;

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
	
	public void excluirComentario(Long idComentario) {
		Comentario comentario = buscarComentarioPorId(idComentario);
		comentarioRepository.deleteById(comentario.getId());
	}
	
	public List<Comentario> listarComentariosPorPostId(Long id){
		return comentarioRepository.findByComentarioPorPostId(id);
	}
	
	public Comentario buscarComentarioPorId(Long id) {
		Optional<Comentario> comentario =  comentarioRepository.findById(id);
		return comentario.get();
	}
}
