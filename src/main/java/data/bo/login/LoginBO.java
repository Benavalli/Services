package data.bo.login;

import data.model.login.Login;
import data.model.login.User;

public interface LoginBO {

    boolean existLogin(String login);

    void saveLogin(Login login);

    Login getLogin(String loginName, String password);

    void deleteLogin(Login login);

    void updateLogin(Login login);
}
