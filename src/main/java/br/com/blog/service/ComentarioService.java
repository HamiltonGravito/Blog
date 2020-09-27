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
	
	public boolean excluirComentario(Long idComentario, Long idUsuario) {
		boolean comentarioExcluido = false;
		List<Comentario> listaDeComentarios = listarComentariosPorPostId(idUsuario);
		Optional<Comentario> comentario = comentarioRepository.findById(idComentario);
		if(listaDeComentarios.contains(comentario.get())) {
			comentarioRepository.deleteById(idComentario);
			comentarioExcluido = true;
		}
		return comentarioExcluido;
	}
	
	public List<Comentario> listarComentariosPorPostId(Long id){
		return comentarioRepository.findByComentarioPorPostId(id);
	}
}
