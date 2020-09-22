package br.com.blog.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.blog.model.Comentario;
import br.com.blog.service.ComentarioService;

@RestController
@CrossOrigin
@RequestMapping("/comentario")
public class ComentarioController {

	@Autowired
	private ComentarioService comentarioService;
	
	@PostMapping
	public ResponseEntity<Comentario> salvar(@RequestBody Comentario comentario){
		Comentario comentarioSalvo = comentarioService.salvarComentario(comentario);
		return ResponseEntity.status(HttpStatus.CREATED).body(comentarioSalvo);
	}
	
	@DeleteMapping
	public void excluir(@RequestParam Long id){
		comentarioService.excluirComentario(id);
	}
}
