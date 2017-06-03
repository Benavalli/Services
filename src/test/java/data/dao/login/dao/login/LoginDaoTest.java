package data.dao.login.dao.login;

import data.bo.login.LoginBO;
import data.dao.login.LoginDao;
import data.hibernate.config.HibernateConfig;
import data.model.login.Login;
import data.model.login.Password;
import data.model.login.User;
import org.hibernate.cfg.Environment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HibernateConfig.class, LoginDao.class})
@Transactional
public class LoginDaoTest {

    @Autowired
    @Mock
    private HibernateTemplate hibernateTemplate;

    @Autowired
    private LoginDao dao;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveLogin() {
        when(hibernateTemplate.save(anyObject())).thenReturn((long)1);
        Login login = createLogin();
        dao.saveLogin(login);
        verify(hibernateTemplate).save(login);
    }

    private Login createLogin() {
        Calendar calendar = Calendar.getInstance();
        Login login = new Login();
        login.setCreateDate(calendar.getTime());
        login.setActive(true);
        login.setLoginName("Marys");
        User user = new User();
        user.setCreateDate(calendar.getTime());
        user.setActive(true);
        user.setName("Mariana");
        user.setEmail("psiu@gmail.com");
        user.setCpf("333.333.333-33");
        user.setCelular("(16)324565431");
        login.setUser(user);
        Password pass = new Password();
        pass.setCreateDate(calendar.getTime());
        pass.setActive(true);
        pass.setPassword("123");
        login.setPassword(pass);
        return login;
    }

}
