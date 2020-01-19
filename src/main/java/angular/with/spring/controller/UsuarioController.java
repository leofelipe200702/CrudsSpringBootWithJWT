package angular.with.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import angular.with.spring.domain.entity.Usuario;
import angular.with.spring.domain.exception.ExcecaoEntidadeEmUsoException;
import angular.with.spring.domain.exception.ExcecaoEntidadeNaoEncontradaException;
import angular.with.spring.domain.service.UsuarioService;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/usuarios")
@RestController
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping()
	public List<Usuario> getAllUsuarios() {
		return this.usuarioService.findAll();
	}
	
	@GetMapping("/{idUsuario}")
	public ResponseEntity<Usuario> findById(@PathVariable("idUsuario") Long idUsuario) {
		Optional<Usuario> usuario = usuarioService.findById(idUsuario);

		if (usuario.isPresent()) {
			return ResponseEntity.ok(usuario.get());
		}

		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{idUsuario}")
	public ResponseEntity<Usuario> remove(@PathVariable("idUsuario") Long idUsuario) {

		try {

			usuarioService.remove(idUsuario);

			return ResponseEntity.noContent().build();

		} catch (ExcecaoEntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		} catch (ExcecaoEntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
	@PutMapping("/{idUsuario}")
	public ResponseEntity<?> update(@PathVariable("idUsuario") Long idUsuario,
			@RequestBody Usuario pUsuario) {

		try {
			Optional<Usuario> usuario = usuarioService.findById(idUsuario);

			if (usuario.isPresent()) {				
				
				// copia as propriedades de um Bean para o outro
				//BeanUtils.copyProperties(pUsuario, usuario.get(), "id");
				
				Usuario usuarioSalvo = usuarioService.save(pUsuario);

				return ResponseEntity.ok(usuarioSalvo);

			}

			return ResponseEntity.notFound().build();
		} catch (ExcecaoEntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Usuario usuario) {

		try {
			usuario = usuarioService.save(usuario);
			return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
		} catch (ExcecaoEntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

}
