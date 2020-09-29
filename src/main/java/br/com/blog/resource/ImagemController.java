package br.com.blog.resource;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.blog.model.Imagem;
import br.com.blog.service.AwsService;
import br.com.blog.service.ImagemService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
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
	
	@GetMapping("/{id}")
	public ResponseEntity<List<String>> buscarImgPeloIdPost(@PathVariable Long id) {
		List<Imagem> listaDeImagens = imagemService.listaDeImagens(id);
		List<String> listaDeCaminhos = new ArrayList<>();
		for (Imagem imagem : listaDeImagens) {
			listaDeCaminhos.add(imagem.getImagemUrl());
			System.out.println("Lista de Imagens" + imagem);
		}
		if(listaDeImagens.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(listaDeCaminhos);
		}
	}
}
