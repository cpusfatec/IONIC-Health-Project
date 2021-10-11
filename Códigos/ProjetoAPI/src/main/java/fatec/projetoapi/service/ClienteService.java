package fatec.projetoapi.service;

import java.util.List;

import org.springframework.data.domain.Page;

import fatec.projetoapi.model.Cliente;

public interface ClienteService {

	public List<Cliente> getAllUsuarios();
	void saveUsuarios(Cliente usuarios);
	Cliente getClienteById(long id);
	void deleteClienteById(long id);
	Page<Cliente> findPaginated(int pageNo, int pageSize);
	
}
