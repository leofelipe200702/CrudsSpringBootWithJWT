package angular.with.spring.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import angular.with.spring.domain.entity.Todo;

public interface TodoJpaRepository extends JpaRepository<Todo, Long>{
	
	public List<Todo> findByUsername(String username);

}
