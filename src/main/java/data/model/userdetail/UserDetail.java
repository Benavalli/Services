package data.model.userdetail;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "autenticacao")
public class UserDetail implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long idUserDetail;

    @Column(name = "usuario", length = 45)
    private String user;

    @Column(name = "senha")
    private String password;

    @Column(name = "role")
    private String role;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_criacao")
    private Date createDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_modificacao", nullable = true)
    private Date modifyDate;

    @Column(name = "ativo")
    @JsonIgnore
    private boolean active;

    public Long getIdUserDetail() {
        return idUserDetail;
    }

    public void setIdUserDetail(Long idUserDetail) {
        this.idUserDetail = idUserDetail;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
}
