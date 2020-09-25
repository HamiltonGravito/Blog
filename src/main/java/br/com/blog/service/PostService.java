package br.com.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.blog.model.Post;
import br.com.blog.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	public Post cadastrarPost(Post post) {
		return postRepository.save(post);
	}
	
	public List<Post> consultarPosts(){
		return postRepository.findAll();
	}
	
	public void excluirPost(Long id) {
		postRepository.deleteById(id);
	}
	
}
