package fatec.projetoapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/listaclientes")
	public ModelAndView clientes() {
		
		ModelAndView andView = new ModelAndView("listaclientes");
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
	
	@GetMapping("/editarcliente/{id}")
	public String editarcliente(@PathVariable(value = "id") long id, Model model) {

		Cliente cliente = clienteRepository.getOne(id);
		model.addAttribute("cliente", cliente);
		return "cadastro/editarcliente";
	}
	
	@PostMapping("/salvarcliente")
	public String salvarcliente(@ModelAttribute("cliente") Cliente cliente) {
		
		clienteRepository.save(cliente);
		return "redirect:/listaclientes";
	}
	
	@GetMapping("/deletarcliente/{id}")
	public String deletarcliente(@PathVariable(value = "id") long id) {

		this.clienteRepository.deleteById(id);
		return "redirect:/listaclientes";

	}
	
}
