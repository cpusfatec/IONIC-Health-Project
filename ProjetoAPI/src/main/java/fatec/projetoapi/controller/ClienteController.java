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
import fatec.projetoapi.model.ClienteB2B;
import fatec.projetoapi.repository.ClienteB2BRepository;
import fatec.projetoapi.repository.ClienteRepository;


@Controller
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteB2BRepository clienteb2bRepository;
	
	@GetMapping("/B2B")
	public String cadastroclienteB2B() {
		return "cadastro/cadastroclienteB2B";
	}
	
	@GetMapping("/B2C")
	public String cadastroclienteB2C() {
		return "cadastro/cadastroclienteB2C";
	}
	
	@GetMapping("/selecionarcadastro")
	public String selecionarcadastrocio() {
		return "cadastro/selecionarcadastro";
	}
	
	@GetMapping("/salvarcliente")
	public ModelAndView salvar(Cliente cliente) {
		
			clienteRepository.save(cliente);
			ModelAndView andView = new ModelAndView("cadastro/cadastrocliente");
			Iterable<Cliente> clientesIt = clienteRepository.findAll();
			andView.addObject("clientes", clientesIt);
			
		return andView;
	}
	
	@GetMapping("/salvarclienteb2b")
	public ModelAndView salvar(ClienteB2B clienteb2b) {
		
			clienteb2bRepository.save(clienteb2b);
			ModelAndView andView = new ModelAndView("cadastro/cadastroclienteB2B");
			Iterable<ClienteB2B> clientesb2bIt = clienteb2bRepository.findAll();
			andView.addObject("clientesb2b", clientesb2bIt);
			
		return andView;
	}
	
	@GetMapping("/listaclientes")
	public ModelAndView clientes() {
		
		ModelAndView andView = new ModelAndView("listaclientes");
		Iterable<Cliente> clientesIt = clienteRepository.findAll();
		andView.addObject("clientes", clientesIt);
		
		Iterable<ClienteB2B> clientesb2bIt = clienteb2bRepository.findAll();
		andView.addObject("clientesb2b", clientesb2bIt);
		
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
	
	@GetMapping("/editarclienteB2B/{id}")
	public String editarclienteb2b(@PathVariable(value = "id") long id, Model model) {

		ClienteB2B clienteb2b = clienteb2bRepository.getOne(id);
		model.addAttribute("clienteb2b", clienteb2b);
		return "cadastro/editarclienteB2B";
	}
	
	@PostMapping("/salvarcliente")
	public String salvarcliente(@ModelAttribute("cliente") Cliente cliente) {
		
		clienteRepository.save(cliente);
		return "redirect:/listaclientes";
	}
	
	@PostMapping("/salvarclienteb2b")
	public String salvarclienteb2b(@ModelAttribute("clienteb2b") ClienteB2B clienteb2b) {
		
		clienteb2bRepository.save(clienteb2b);
		return "redirect:/listaclientes";
	}
	
	@GetMapping("/deletarcliente/{id}")
	public String deletarcliente(@PathVariable(value = "id") long id) {

		this.clienteRepository.deleteById(id);
		return "redirect:/listaclientes";

	}
	
	@GetMapping("/deletarclienteB2B/{id}")
	public String deletarclienteb2b(@PathVariable(value = "id") long id) {

		this.clienteb2bRepository.deleteById(id);
		return "redirect:/listaclientes";

	}
	
}
