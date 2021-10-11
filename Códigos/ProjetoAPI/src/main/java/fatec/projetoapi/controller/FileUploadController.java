package fatec.projetoapi.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
	
	public static String uploadDirectory = "../Root/";
	
	BlockControllers bc = new BlockControllers();

	@PostMapping("/UploadFile")
	public String upload(Model model,@RequestParam("files") MultipartFile[] files) {	
		StringBuilder fileNames = new StringBuilder();
		for(MultipartFile file:files) {
			
			
			
			File CreateFile = bc.toFile(uploadDirectory);
			CreateFile.mkdirs();
					
			Path fileNameAndPath = Paths.get(uploadDirectory,file.getOriginalFilename());
			fileNames.append(file.getOriginalFilename());
			try {
				
				Files.write(fileNameAndPath, file.getBytes());
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "import";
	}
}
