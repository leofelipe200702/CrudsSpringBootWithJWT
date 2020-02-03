package angular.with.spring.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import angular.with.spring.domain.entity.UserApplication;

public interface UsuarioSistemaJpaRepository extends JpaRepository<UserApplication, Long>{
	
	public Optional<UserApplication> findByUsername(String username);

    /**
     * @param usernameOrEmail
     * @return
     */
    public Optional<UserApplication> findByUsernameOrEmail(String username, String email);

}
