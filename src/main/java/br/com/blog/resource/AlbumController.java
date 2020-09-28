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

import br.com.blog.model.Album;
import br.com.blog.service.AlbumService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
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
	
	@DeleteMapping("/{idAlbum}/{idUsuario}")
    public ResponseEntity<?> deletarAlbum(@PathVariable Long idAlbum, @PathVariable Long idUsuario) {
		if(albumService.listarAlbumPorIdUsuario(idUsuario).contains(albumService.confirmarUsuarioAlbum(idAlbum, idUsuario))) {
			albumService.excluirAlbum(idAlbum, idUsuario);
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@RequestMapping("/{imagemUrl}/{idAlbum}/{idUsuario}")
	public ResponseEntity<?> salvarImagemNoAlbum(@PathVariable String imagemUrl, @PathVariable Long idAlbum, @PathVariable Long idUsuario){
		albumService.adicionarImagemALbum(imagemUrl, idAlbum, idUsuario);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
}
