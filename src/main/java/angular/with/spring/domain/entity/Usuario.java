package angular.with.spring.domain.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name="usuario")
public class Usuario {
	
	@ApiModelProperty(value = "Código do Usuário")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param password
	 * @param telefones
	 */
	public Usuario(Long id, String firstName, String lastName, String email, String password,
			List<Telefone> telefones) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.telefones = telefones;
	}
	
	public Usuario() {
		
	}
	
	@ApiModelProperty(value = "Nome do Usuário")
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@ApiModelProperty(value = "SobreNome do Usuário")
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@ApiModelProperty(value = "Email do Usuário")
	@Column(name = "email", nullable = false)
	private String email;
	
	@ApiModelProperty(value = "Senha do Usuário")
	@Column(name = "password", nullable = false)
	private String password;
	
	@ApiModelProperty(value = "Telefones do Usuário")
	@JsonManagedReference
	@OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL,
	        orphanRemoval = true)
	private List<Telefone> telefones;	
	
}
