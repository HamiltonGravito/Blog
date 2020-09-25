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
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.blog.model.Imagem;
import br.com.blog.model.Link;
import br.com.blog.model.Post;
import br.com.blog.model.PostImagem;
import br.com.blog.service.ImagemService;
import br.com.blog.service.LinkService;
import br.com.blog.service.PostImagemService;
import br.com.blog.service.PostService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostService postService;
	
	@Autowired(required = true)
	private LinkService linkService;
	
	@Autowired(required = true)
	private ImagemService imagemService;
	
	@Autowired(required = true)
	private PostImagemService postImagemService;
	
	@PostMapping
	public ResponseEntity<Post> salvar(@RequestBody Post post){
		List<String> links = post.getListaLinks();
		Link link;
		List<String> imagens = post.getListaImagens();
		PostImagem postImagem;
		Imagem imagemSalva;
		Post postSalvo = postService.cadastrarPost(post);
		
		for (String valor : links) {
			link = new Link(valor);
			link.setPostId(postSalvo);
			linkService.salvarLink(link);
		}
		
		for (String valor : imagens) {
			imagemSalva = new Imagem(valor);
			imagemService.salvarUrlImagem(imagemSalva);
			
			postImagem = new PostImagem(imagemSalva, postSalvo);
			postImagemService.salvarPostImagem(postImagem);
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(postSalvo);	
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		postService.excluirPost(id);
	}
	
	@GetMapping
	public ResponseEntity<List<Post>> listarPost(){
		List<Post> listaPost = postService.consultarPosts();
		return !listaPost.isEmpty() ? ResponseEntity.ok(listaPost) : ResponseEntity.noContent().build();
	}
	
}
