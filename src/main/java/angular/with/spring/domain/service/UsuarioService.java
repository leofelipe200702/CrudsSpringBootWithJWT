package angular.with.spring.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import angular.with.spring.domain.entity.Usuario;
import angular.with.spring.domain.exception.ExcecaoEntidadeEmUsoException;
import angular.with.spring.domain.exception.ExcecaoEntidadeNaoEncontradaException;
import angular.with.spring.domain.repository.UsuarioJpaRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioJpaRepository usuarioRepository;

	public List<Usuario> findAll() {
		return this.usuarioRepository.findAll();
	}

	public Optional<Usuario> findById(Long idUsuario) {
		return this.usuarioRepository.findById(idUsuario);
	}

	public void remove(Long idUsuario) {

		try {

			usuarioRepository.deleteById(idUsuario);

		} catch (EmptyResultDataAccessException e) {
			throw new ExcecaoEntidadeNaoEncontradaException(
					String.format("Não existe usuário com o código %d", idUsuario));
		} catch (DataIntegrityViolationException e) {
			throw new ExcecaoEntidadeEmUsoException(
					String.format("O usuário de código %d está em uso e não pode ser excluído", idUsuario));
		}
	}
	
	public Usuario save(Usuario pUsuario) {
		return usuarioRepository.save(pUsuario);
	}

}
