package fatec.projetoapi.controller;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fatec.projetoapi.model.Cliente;
import fatec.projetoapi.repository.ClienteRepository;


@Controller
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/cadastrocliente")
	public String inicio() {
		return "cadastro/cadastrocliente";
	}
	
	@GetMapping("/salvarcliente")
	public ModelAndView salvar(Cliente cliente) {
			clienteRepository.save(cliente);
			
			ModelAndView andView = new ModelAndView("cadastro/cadastrocliente");
			Iterable<Cliente> clientesIt = clienteRepository.findAll();
			andView.addObject("clientes", clientesIt);
			
		return andView;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/listaclientes")
	public ModelAndView clientes() {
		ModelAndView andView = new ModelAndView("cadastro/cadastrocliente");
		Iterable<Cliente> clientesIt = clienteRepository.findAll();
		andView.addObject("clientes", clientesIt);
		return andView;
	}
	
	@GetMapping("/editarcadastro/{idcliente}")
	public ModelAndView editar (@PathVariable("idcliente") Long idcliente) {
		
		Optional<Cliente> cliente = clienteRepository.findById(idcliente);
		
		ModelAndView modelAndView = new ModelAndView("cadastro/cadastrocliente");
		modelAndView.addObject("clienteobj", cliente.get());
		return modelAndView;
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

		// pega o usuário do bd
		Cliente cliente = clienteRepository.getOne(id);

		// set user as a model attribute to pre-populate the form
		model.addAttribute("cliente", cliente);
		return "cadastro/editarcliente";
	}
	
	@PostMapping("/saveUsuarios")
	public String saveUsuarios(@ModelAttribute("cliente") Cliente cliente) {
		// salva o usuario no banco
		clienteRepository.save(cliente);
		return "redirect:/listaclientes";
	}
	
}
