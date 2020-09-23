package br.com.blog.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.blog.model.PostImagem;
import br.com.blog.service.PostImagemService;

@RestController
@CrossOrigin
@RequestMapping("/postimg")
public class PostImagemController {
	
	@Autowired
	private PostImagemService postImagemService;

	@GetMapping
	public ResponseEntity<List<PostImagem>> retornarObjetos() {
		List<PostImagem> listaPostImagem = postImagemService.listar();
		return new ResponseEntity<>(listaPostImagem, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<PostImagem> cadastrarObjetos(@RequestBody PostImagem postImagem) {
		PostImagem postImagemCadastrada = postImagemService.salvarPostImagem(postImagem);
		return new ResponseEntity<PostImagem>(postImagemCadastrada, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/postimg" + "/imagens", params = { "id" }, method = RequestMethod.GET)
	public ResponseEntity<List<PostImagem>> findPostImagemByPosId(@RequestParam(value = "id") Long postId) {
		List<PostImagem> listaPostImagemsPorPost = postImagemService.listarPorPostId(postId);
		return new ResponseEntity<>(listaPostImagemsPorPost, HttpStatus.OK);
	}
}