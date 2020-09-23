package br.com.blog.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.blog.model.Link;
import br.com.blog.service.LinkService;

@RestController
@CrossOrigin
@RequestMapping("/post/link")
public class LinkController {
	
	@Autowired
	private LinkService linkService;
	
	@PostMapping
	public ResponseEntity<Link> salvar(@RequestBody Link link){
		Link linkSalvo = linkService.salvarLink(link);
		return ResponseEntity.status(HttpStatus.CREATED).body(linkSalvo);	
	}

}
