package fatec.projetoapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
public class InMemorySecurityConfig {
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder
			.inMemoryAuthentication()
			.withUser("gerente").password("{noop}123").roles("gerente", "gestor", "vendedor")
			.and()
			.withUser("gestor").password("{noop}123").roles("gestor", "vendedor")
			.and()
			.withUser("vendedor").password("{noop}123").roles("vendedor");
	}

}
