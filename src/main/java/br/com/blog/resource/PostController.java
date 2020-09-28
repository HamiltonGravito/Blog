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

import br.com.blog.model.Imagem;
import br.com.blog.model.Link;
import br.com.blog.model.Post;
import br.com.blog.service.ImagemService;
import br.com.blog.service.LinkService;
import br.com.blog.service.PostService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostService postService;

	@Autowired(required = true)
	private LinkService linkService;

	@Autowired(required = true)
	private ImagemService imagemService;

	@PostMapping("/cadastrar")
	public ResponseEntity<Post> salvar(@RequestBody Post post) {
		if (post != null) {
			List<String> links = post.getListaLinks();
			Link link;
			List<String> imagens = post.getListaImagens();
			Imagem imagem;
			Post postSalvo = postService.cadastrarPost(post);

			if (post.getLinks() != null) {
				for (String valor : links) {
					link = new Link(valor);
					link.setPostId(postSalvo);
					linkService.salvarLink(link);
				}
			}

			if (post.getImagens() != null) {
				for (String valor : imagens) {
					imagem = new Imagem(valor);
					imagem.setPostId(postSalvo);
					imagemService.salvarUrlImagem(imagem);
				}
			}
			return ResponseEntity.status(HttpStatus.CREATED).body(postSalvo);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@DeleteMapping("deletar/{idPost}/{idUsuario}")
	public ResponseEntity<?> excluir(@PathVariable Long idPost, @PathVariable Long idUsuario) {
		Post post = postService.buscarPostPorId(idPost);
		if(post.getUsuarioId().getId() == idUsuario) {
			postService.excluirPost(idPost);
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/buscar")
	public ResponseEntity<List<Post>> listarPost() {
		List<Post> listaPost = postService.listarPosts();
		return !listaPost.isEmpty() ? ResponseEntity.ok(listaPost) : ResponseEntity.noContent().build();
	}

}
