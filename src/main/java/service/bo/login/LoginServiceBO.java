package service.bo.login;

import data.model.login.Login;
import org.springframework.security.access.annotation.Secured;

public interface LoginServiceBO {

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    void insertLogin(Login login);

    @Secured ({"ROLE_ADMIN", "ROLE_USER"})
    void deleteLogin(Login login);

    @Secured ({"ROLE_ADMIN", "ROLE_USER"})
    void updateLogin(Login login);

    @Secured ({"ROLE_USER"})
    Login getLogin(String loginName, String password);

    @Secured ({"ROLE_USER"})
    boolean existLogin(String loginName);
}
