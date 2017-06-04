package data.dao.login;

import java.util.List;

import data.bo.login.LoginBO;
import data.model.login.Login;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDao implements LoginBO{

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public boolean existLogin(String loginName) {
		List<Login> loginList = (List<Login>) hibernateTemplate.findByCriteria(DetachedCriteria.forClass(Login.class, "l")
				.add(Restrictions.eq("loginName", loginName))
				.add(Restrictions.eq("active", true)));

		return loginList.isEmpty() ? false : true;
	}

	public void saveLogin(Login login) {
		hibernateTemplate.save(login);
	}

	public Login getLogin(String loginName, String password) {

		List<Login> loginList =(List<Login>) hibernateTemplate.findByCriteria(DetachedCriteria.forClass(Login.class, "l")
				.createAlias("l.user", "usuario")
				.createAlias("l.password", "senha")
				.add(Restrictions.eq("loginName", loginName))
				.add(Restrictions.eq("senha.passwordCrypted", password))
				.add(Restrictions.eq("active", true))
				.add(Restrictions.eq("usuario.active", true))
				.add(Restrictions.eq("senha.active", true)));

		return loginList.isEmpty() ? null : loginList.get(0);

	}

	public void deleteLogin(Login login) {
		hibernateTemplate.delete(login);
	}

	public void updateLogin(Login login) {
		hibernateTemplate.update(login);
	}
	
}