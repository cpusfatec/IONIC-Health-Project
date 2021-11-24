package fatec.projetoapi.Filtro;
import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

@WebFilter(urlPatterns = "/B2B", dispatcherTypes = {DispatcherType.REQUEST})
public class FiltroDeAcesso extends HttpFilter{
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
        throws IOException, ServletException { 
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal instanceof UserDetails) {
            String username = ((UserDetails)principal).getUsername();
		    System.out.println(username);
            response.sendRedirect("/B2C");
            } 
            else {
            String username = principal.toString();
            }
                chain.doFilter(request, response); 
        } 
}    

