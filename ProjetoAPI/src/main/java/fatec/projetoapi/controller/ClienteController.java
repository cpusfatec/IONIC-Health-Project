package fatec.projetoapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fatec.projetoapi.model.Cliente;
import fatec.projetoapi.repository.ClienteRepository;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@RequestMapping(method = RequestMethod.GET, value = "/cadastrocliente")
	public String inicio() {
		return "cadastro/cadastrocliente";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/salvarcliente")
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
	
}
