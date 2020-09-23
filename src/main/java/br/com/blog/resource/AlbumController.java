package br.com.blog.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.blog.model.Album;
import br.com.blog.model.Imagem;
import br.com.blog.service.AlbumService;

@RestController
@CrossOrigin
@RequestMapping("/album")
public class AlbumController {

	@Autowired
	private AlbumService albumService;
	
	@GetMapping
	public ResponseEntity<List<Album>> listarAlbuns(){
		List<Album> albuns = albumService.listarAlbuns();
		return ResponseEntity.status(HttpStatus.OK).body(albuns); 
	}
	
	@PostMapping
	public ResponseEntity<Album> salvarAlbum(@RequestBody Album album){
		Album albumSalvo = albumService.salvarAlbum(album);
		return ResponseEntity.status(HttpStatus.CREATED).body(albumSalvo);
	}
	
	@DeleteMapping
	public void excluirAlbum(@RequestParam Long id) {
		albumService.excluirAlbum(id);
	}
	
	@PostMapping("/img")
	public ResponseEntity<Album> salvarImagemNoAlbum(@RequestBody Imagem imagem, @RequestParam Long id){
		Album albumAtualizado = albumService.adicionarImagemALbum(imagem, id);
		return ResponseEntity.status(HttpStatus.OK).body(albumAtualizado);
	}
}
