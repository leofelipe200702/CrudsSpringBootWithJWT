package angular.with.spring.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import angular.with.spring.domain.entity.UserApplication;
import angular.with.spring.domain.exception.ExcecaoEntidadeEmUsoException;
import angular.with.spring.domain.exception.ExcecaoEntidadeNaoEncontradaException;
import angular.with.spring.domain.exception.ObjectNotFoundException;
import angular.with.spring.domain.repository.UsuarioSistemaJpaRepository;

@Service
public class UsuarioSistemaService {

	@Autowired
	private UsuarioSistemaJpaRepository usuarioSistemaRepository;

	public List<UserApplication> findAll() {
		return this.usuarioSistemaRepository.findAll();
	}

	public Optional<UserApplication> findById(Long idUsuario) {
		return this.usuarioSistemaRepository.findById(idUsuario);
	}

	public void remove(Long idUsuario) {

		try {

			usuarioSistemaRepository.deleteById(idUsuario);

		} catch (EmptyResultDataAccessException e) {
			throw new ExcecaoEntidadeNaoEncontradaException(
					String.format("Não existe usuário com o código %d", idUsuario));
		} catch (DataIntegrityViolationException e) {
			throw new ExcecaoEntidadeEmUsoException(
					String.format("O usuário de código %d está em uso e não pode ser excluído", idUsuario));
		}
	}
	
	public UserApplication findByUsername(String username) {
        return usuarioSistemaRepository.findByUsername(username).orElseThrow(() -> new ObjectNotFoundException(
                "Usuário não encontrado! Username: " + username + ", tipo " + UserApplication.class.getName()));
    }
	
	public UserApplication save(UserApplication pUsuario) {
		return usuarioSistemaRepository.save(pUsuario);
	}

}
