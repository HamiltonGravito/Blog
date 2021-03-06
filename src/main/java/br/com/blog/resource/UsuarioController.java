package br.com.blog.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.blog.model.Usuario;
import br.com.blog.service.UsuarioService;

@RestController
@CrossOrigin
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario){
		Usuario usuarioSalvo = usuarioService.salvarUsuario(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
	}
	
}
