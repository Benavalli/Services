package service.login;

import data.bo.login.LoginBO;
import data.model.login.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginService {

    @Autowired
    LoginBO loginBO;

    public void insertLogin(Login login) {
        loginBO.saveLogin(login);
    }

    public void deleteLogin(Login login) {
        loginBO.deleteLogin(login);
    }

    public void updateLogin(Login login) {
        loginBO.updateLogin(login);
    }

    public Login getLogin(String loginName, String password) {
        return loginBO.getLogin(loginName, password);
    }

    public boolean existLogin(String loginName) {
        return loginBO.existLogin(loginName);
    }



}
