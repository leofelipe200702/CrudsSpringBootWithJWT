package angular.with.spring.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "telefone")
public class Telefone {
	
	@ApiModelProperty(value = "Sequencial Interno do Telefone")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	@ApiModelProperty(value = "Número do Telefone")
	@Column(name = "number", nullable = false)
	private String number;
	
	@ApiModelProperty(value = "Código de Área do Telefone")
	@Column(name = "area_code", nullable = false)
	private String areaCode;
	
	@ApiModelProperty(value = "Código do País do Telefone")
	@Column(name = "country_code", nullable = false)
	private String countryCode;
	
	@ApiModelProperty(value = "Tipo do Telefone")
	@Column(name = "tp_telefone", nullable = false)
	private String tipoTelefone;
	
	@ApiModelProperty(value = "Código do Usuário Proprietário do Telefone")
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario", nullable = false)
	private Usuario usuario;

	public Telefone() {

	}

	/**
	 * @param id
	 * @param number
	 * @param areaCode
	 * @param countryCode
	 * @param tipoTelefone
	 * @param usuario
	 */
	public Telefone(Long id, String number, String areaCode, String countryCode, String tipoTelefone, Usuario usuario) {
		super();
		this.id = id;
		this.number = number;
		this.areaCode = areaCode;
		this.countryCode = countryCode;
		this.tipoTelefone = tipoTelefone;
		this.usuario = usuario;
	}

}
