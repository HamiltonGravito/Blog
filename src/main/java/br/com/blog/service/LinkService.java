package br.com.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.blog.model.Link;
import br.com.blog.repository.LinkRepository;

@Service
public class LinkService {

	@Autowired
	private LinkRepository linkRepository;
	
	public Link salvarLink(Link link) {
		return linkRepository.save(link);
	}
	
	public List<Link> listarLinkIdPost(Long id){
		return linkRepository.linksPorPost(id);
	}
}
