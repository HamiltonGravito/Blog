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

import br.com.blog.service.AwsService;
import br.com.blog.service.ImagemService;

@RestController
@CrossOrigin
@RequestMapping("/imagem")
public class ImagemController {

	@Autowired
	private ImagemService imagemService;
	
	@Autowired(required = true)
	private AwsService s3Service;
	
	@PostMapping
	public ResponseEntity<String> adicionarImagem(@RequestParam MultipartFile file) {
		File arquivo = null;
		String pathAWS = "https://eventarea.s3-us-west-1.amazonaws.com/";
		try {
			arquivo =  imagemService.salvarImagem(file);
			System.out.println(arquivo.getName());
			s3Service.uploadFile(arquivo, arquivo.getName());
		} catch (Exception e) {
			System.out.println("Erro ao Salvar Imagem: " + e);
		}finally {
			if(arquivo.exists()) {
				arquivo.delete();
			}
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(pathAWS + arquivo.getName());
	}
}
