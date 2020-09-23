package br.com.blog.resource;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.blog.service.ImagemService;

@RestController
@CrossOrigin
@RequestMapping("/imagem")
public class ImagemController {

	@Autowired
	private ImagemService imagemService;
	
	@PostMapping
	public ResponseEntity<File> adicionarImagemLocal(@RequestParam MultipartFile file) {
		File arquivo = null;
		try {
			arquivo =  imagemService.salvarImagemLocal(file);
			System.out.println("Cheguei no File: " + arquivo);
			return ResponseEntity.status(HttpStatus.CREATED).body(arquivo);
		} catch (Exception e) {
			System.out.println("Erro ao Salvar Imagem: " + e);
			arquivo = null;
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(null);
		}finally {
		
		}
	}
}
