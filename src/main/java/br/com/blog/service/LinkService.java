package br.com.blog.service;

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
}
