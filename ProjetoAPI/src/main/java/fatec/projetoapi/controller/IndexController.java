package fatec.projetoapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/login")
	public String login( ) {
		return "entrar";
	}
	
	@RequestMapping("/import")
	public String Import( ) {
		return "import";
	}
	
	@RequestMapping("/pipeline")
	public String pipeline( ) {
		return "pipeline";
	}
	
	@RequestMapping("/cadastrouser")
	public String cadastrouser( ) {
		return "cadastro/cadastrouser";
	}
	
}
