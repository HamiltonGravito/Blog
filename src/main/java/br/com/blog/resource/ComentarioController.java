package br.com.blog.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.blog.model.Comentario;
import br.com.blog.model.Post;
import br.com.blog.model.Usuario;
import br.com.blog.service.ComentarioService;
import br.com.blog.service.PostService;
import br.com.blog.service.UsuarioService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/comentario")
public class ComentarioController {

	@Autowired
	private ComentarioService comentarioService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PostService postService;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Comentario> salvar(@RequestBody Comentario comentario){
		Usuario usuario = usuarioService.buscarPorId(comentario.getUsuarioId().getId());
		Post post = postService.buscarPostPorId(comentario.getPostId().getId());
		Comentario novoComentario = new Comentario(comentario.getComentario(), post, usuario);
		comentarioService.salvarComentario(novoComentario);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoComentario);	
	}
	
	
	@DeleteMapping("delete/{idComentario}/{idUsuario}")
	public ResponseEntity<?> excluir(@PathVariable Long idComentario, @PathVariable Long idUsuario) {
		Comentario comentario = comentarioService.buscarComentarioPorId(idComentario);
		if(comentario.getUsuarioId().getId() == idUsuario) {
			comentarioService.excluirComentario(idComentario);
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<List<Comentario>> buscarComentarioPeloIdPost(@PathVariable Long id) {
		List<Comentario> listaDeComentarios = comentarioService.listarComentariosPorPostId(id);
		if(listaDeComentarios.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(listaDeComentarios);
		}
	}
}
