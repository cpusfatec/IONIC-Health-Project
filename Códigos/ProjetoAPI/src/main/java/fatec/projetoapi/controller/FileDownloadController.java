package fatec.projetoapi.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.google.common.io.Files;

@Controller
public class FileDownloadController {
	
	BlockControllers bc = new BlockControllers();
	
	public static String Directory = "../Root/";
	
	@GetMapping("/DownloadFile")
	public void DownloadFile(String document, HttpServletRequest request, HttpServletResponse response ) throws Exception {		
		
		String fileName = null;
		
		
		Directory = Directory + document + ".xlsx";
		fileName = document + ".xlsx";
    				
		
		File pathDirectory = bc.toFile(Directory);		
		
		response.setContentType("application/pdf");
        response.addHeader("Content-Disposition", "attachment; filename="+fileName);
        try
        {
            Files.copy(pathDirectory, response.getOutputStream());
            response.getOutputStream().flush();
        } 
        catch (IOException ex) {
            ex.printStackTrace();
        }

		Directory = "../Root/";
	
	}
}
