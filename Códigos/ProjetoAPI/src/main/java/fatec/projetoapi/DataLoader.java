package fatec.projetoapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import fatec.projetoapi.model.Usuario;
import fatec.projetoapi.repository.UsuarioRepository;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public void run(String... args) throws Exception {
    	

        if( usuarioRepository.findByNome("admin") == null ){
        Usuario user = new Usuario("admin", passwordEncoder.encode("123456"));
        usuarioRepository.save(user);
        }
        
    }
}
