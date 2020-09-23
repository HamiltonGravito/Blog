package br.com.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.blog.model.Album;
import br.com.blog.model.Imagem;
import br.com.blog.repository.AlbumRepository;

@Service
public class AlbumService {

	@Autowired
	private AlbumRepository albumRepository;
	
	public Album salvarAlbum(Album album) {
		return albumRepository.save(album);
	}
	
	public void excluirAlbum(Long id) {
		albumRepository.deleteById(id);
	}
	
	public Album adicionarImagemALbum(Imagem imagem, Long id) {
		Album albumRecuperado =  albumRepository.getOne(id);
		albumRecuperado.getImagens().add(imagem);
		return albumRecuperado;
	}
	
	public List<Album> listarAlbuns(){
		return albumRepository.findAll();
	}
}
