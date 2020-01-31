package angular.with.spring.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import angular.with.spring.domain.entity.Usuario;

public interface UsuarioJpaRepository extends JpaRepository<Usuario, Long>{
	
	public Optional<Usuario> findByFirstName(String username);

}
