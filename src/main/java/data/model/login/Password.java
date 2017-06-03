package data.model.login;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "senha")
public class Password implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private Long idPassword;
		
	@Column(name = "senha", length = 8)
	private String passwordCrypted;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_criacao")
	private Date createDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_modificacao", nullable = true)
	private Date modifyDate;

	@Column(name = "ativo")
	@JsonIgnore
	private boolean active;
	
	public Long getIdPassword() {
		return idPassword;
	}
	
	public void setIdPassword(Long idPassword) {
		this.idPassword = idPassword;
	}
		
	public String getPassword() {
		return passwordCrypted;
	}
	
	public void setPassword(String password) {
		this.passwordCrypted = password;
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
	public boolean equals(Object obj) {
		if(obj != null && obj.getClass().equals(Password.class)) {
			return passwordCrypted.equals(((Password)obj).getPassword());
		}
		return false;
	}
	
	@Override
	public int hashCode() {		
		return this.passwordCrypted.hashCode();
	}	
	
}
