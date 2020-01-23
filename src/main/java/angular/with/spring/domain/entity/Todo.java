package angular.with.spring.domain.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Todo {
	
	@ApiModelProperty(value = "Código da tarefa")
	@Id
	@GeneratedValue
	private Long id;
	
	@ApiModelProperty(value = "Usuário proprietário da tarefa")
	private String username;
	@ApiModelProperty(value = "Descrição da tarefa")
	private String description;
	@ApiModelProperty(value = "Data Alvo da tarefa")
	private Date targetDate;
	@ApiModelProperty(value = "Conclusão da tarefa")
	private boolean isDone;

	public Todo() {

	}

	public Todo(long id, String userName, String description, Date targetDate, boolean isDone) {
		super();
		this.id = id;
		this.username = userName;
		this.description = description;
		this.targetDate = targetDate;
		this.isDone = isDone;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
