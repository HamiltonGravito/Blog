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
	
	@Autowired
	private ImagemService imagemService;
	
	public Album salvarAlbum(Album album) {
		return albumRepository.save(album);
	}
	
	public List<Album> listarAlbuns(){
		return albumRepository.findAll();
	}
	
	public List<Album> listarAlbumPorIdUsuario(Long id){
		return albumRepository.buscarAlbunsPorUsuarioId(id);
	}
	
	public Album confirmarUsuarioAlbum(Long idAlbum, Long idUsuario) {
		Album meuAlbum = null;
		List<Album> listaDeAlbunsUsuario = listarAlbumPorIdUsuario(idUsuario);
		
		for (Album album : listaDeAlbunsUsuario) {
			if(album.getId() == idAlbum){
				meuAlbum = album;
				break;
			}
		}
		return meuAlbum;
	}
	
	public void adicionarImagemALbum(String imagemUrl, Long idAlbum, Long idUsuario) {
		Album meuAlbum = confirmarUsuarioAlbum(idAlbum, idUsuario);
		meuAlbum.getImagens().add(new Imagem(imagemUrl));
		for (Imagem img : meuAlbum.getImagens()) {
			imagemService.salvarUrlImagem(img);
		}
	}
	
	public void excluirAlbum(Long idAlbum, Long idUsuario) {
		Album meuAlbum = confirmarUsuarioAlbum(idAlbum, idUsuario);
		if(meuAlbum != null) {
			albumRepository.deleteById(meuAlbum.getId());
		}
	}
	
	
}
