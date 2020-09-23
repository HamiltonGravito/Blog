package br.com.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.blog.model.PostImagem;
import br.com.blog.repository.PostImagemRepository;

@Service
public class PostImagemService {

	@Autowired
	private PostImagemRepository postImagemRepository;
	
	public PostImagem salvarPostImagem(PostImagem postImagem) {
		return postImagemRepository.save(postImagem);
	}
	
	public List<PostImagem> listar() {
		return postImagemRepository.findAll();
	}
	
	public List<PostImagem> listarPorPostId(Long id){
		return postImagemRepository.imagensPorPost(id);
	}
}
