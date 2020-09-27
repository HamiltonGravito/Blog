package br.com.blog.service;

import java.util.List;
import java.util.Optional;

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
	
	public List<Post> listarPosts(){
		return postRepository.findAll();
	}
	
	public void excluirPost(Long idPost) {
		Post post = buscarPostPorId(idPost);
		postRepository.deleteById(post.getId());
	}
	
	public Post buscarPostPorId(Long id) {
		Optional<Post> post = postRepository.findById(id);
		return post.get();
	}
	
}
