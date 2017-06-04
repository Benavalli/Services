package data.model.login;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "usuario")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private Long idUser;
	
	@Column(name = "nome", length = 100)
	private String name;

	@Column(name = "cpf", length = 15)
	private String cpf;
	
	@Column(name = "email", length = 80)
	private String email;
	
	@Column(name = "celular", length = 20)
	private String celular;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_criacao")
	private Date createDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_modificacao", nullable = true)
	private Date modifyDate;

	@Column(name = "ativo")
	@JsonIgnore
	private boolean active;

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCelular() {
		return celular;
	}
	
	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return String.format("User { name = %s, cpf = %s }" , name, cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj.getClass().equals(User.class)) {
			return cpf.equals(((User)obj).getCpf());
		}
		return false;
	}
	
	@Override
	public int hashCode() {		
		return this.cpf.hashCode();
	}	
	
}
