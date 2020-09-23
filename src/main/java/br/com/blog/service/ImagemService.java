package br.com.blog.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.blog.model.Imagem;
import br.com.blog.repository.ImagemRepository;

@Service
public class ImagemService {
	
	@Autowired
	private ImagemRepository imagemRepository;
	
	public File salvarImagemLocal(MultipartFile arquivo) {
		byte[] imgUpload;
		Path path = Paths.get("src/main/resources/imgtemp/", arquivo.getOriginalFilename());
		try {
			imgUpload = arquivo.getBytes();
			FileOutputStream in = new FileOutputStream(path.toFile());
			in.write(imgUpload);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path.toFile();
	}
	
	public Imagem salvar(Imagem imagem) {
		return imagemRepository.save(imagem);
	}
}
