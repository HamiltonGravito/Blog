package br.com.blog.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.blog.model.Usuario;
import br.com.blog.service.UsuarioService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/cadastrar")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void salvar(@RequestBody Usuario usuario){
		usuarioService.salvarUsuario(usuario);
	}
	
	@PostMapping("/logar")
	public ResponseEntity<Usuario> validarLogin(@RequestBody Usuario usuario) {
		Usuario usuarioValido = usuarioService.validarAcesso(usuario.getNome(), usuario.getSenha());
		if(usuarioValido != null ) {
			usuarioValido.setNome(null);
			usuarioValido.setSenha(null);
			return ResponseEntity.status(HttpStatus.OK).body(usuarioValido);
			
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscarPeloCodigo(@PathVariable Long id) {
		Usuario usuarioRetornado = usuarioService.buscarPorId(id);
		if(usuarioRetornado!= null ) {
			usuarioRetornado.setNome(null);
			usuarioRetornado.setSenha(null);
			return ResponseEntity.status(HttpStatus.OK).body(usuarioRetornado);
			
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
