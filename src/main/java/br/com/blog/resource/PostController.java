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

import br.com.blog.model.Post;
import br.com.blog.service.PostService;

@RestController
@CrossOrigin
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostService postService;
	
	@PostMapping
	public ResponseEntity<Post> salvar(@RequestBody Post post){
		Post postSalvo = postService.cadastrarPost(post);
		return ResponseEntity.status(HttpStatus.CREATED).body(postSalvo);	
	}
	
	@DeleteMapping
	public void excluir(@RequestParam Long id) {
		postService.excluirPost(id);
	}
}
