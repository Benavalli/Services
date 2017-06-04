package service.bo.login;

import data.model.login.Login;
import org.springframework.security.access.annotation.Secured;

public interface LoginServiceBO {

    @Secured({"ADMIN"})
    void insertLogin(Login login);

    @Secured ({"ADMIN"})
    void deleteLogin(Login login);

    @Secured ({"ADMIN"})
    void updateLogin(Login login);

    @Secured ({"ADMIN", "USER"})
    Login getLogin(String loginName, String password);

    @Secured ({"ADMIN", "USER"})
    boolean existLogin(String loginName);
}
