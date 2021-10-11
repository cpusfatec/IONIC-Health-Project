package fatec.projetoapi.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import fatec.projetoapi.repository.BlockRepository;


@Controller
@RequestMapping(value="/api")
public class BlockControllers {

	@Autowired
	BlockRepository blockRepository;
	
	public File toFile(String dir) {
		File teste = new File(dir);
		return teste;
	}
}
	
	
	

