package angular.with.spring.config.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import angular.with.spring.domain.entity.Usuario;
import angular.with.spring.domain.service.UsuarioService;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {
	
  @Autowired
  private UsuarioService userService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
	  
	  Usuario user = userService.findByUsername(username);
      
	  if (user == null)
          throw new UsernameNotFoundException(username);
            
      return new JwtUserDetails(user.getId(), user.getFirstName(),
    	        user.getPassword(), "ROLE_USER_2");
	  
  }

}


