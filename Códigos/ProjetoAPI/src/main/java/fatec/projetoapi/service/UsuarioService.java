package fatec.projetoapi.service;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import fatec.projetoapi.model.Usuario;
import fatec.projetoapi.repository.UsuarioRepository;

@Transactional
@Service
public class UsuarioService implements UserDetailsService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
        try {
        	Usuario usuario = usuarioRepository.findByNome(nome);

            return new org.springframework.security.core.userdetails.User(usuario.getNome(), usuario.getSenha(), getAuthories(usuario));
        }

        catch (Exception e)
        {
         throw new UsernameNotFoundException("Usuario não encontrado!");
        }
    }

    private Set<GrantedAuthority> getAuthories(Usuario usuario){

        Set<GrantedAuthority> authorities = new HashSet<>();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ADMIN");
        authorities.add(grantedAuthority);
        
        return authorities;
    }
}
