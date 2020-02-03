package angular.with.spring.config.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import angular.with.spring.domain.entity.UserApplication;
import angular.with.spring.domain.service.UsuarioSistemaService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
  @Autowired
  private UsuarioSistemaService userService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
	  
	  UserApplication user = userService.findByUsername(username);
      
	  if (user == null)
          throw new UsernameNotFoundException(username);
            
   return new UserOfSystem(user.getUsername(), user.getPassword(), user.isActive(), user.getRoles());
      
      
      
	  
  }

}


