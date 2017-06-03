package data.dao.login.hibernate.config;

import data.hibernate.config.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HibernateConfig.class})
@Transactional
public class HibernateConfigTest {

   @Autowired
   private SessionFactory sessionFactory;

   @Autowired
   private DataSource getDataSource;

   @Test
   public void verifySessionFactory() {
       Assert.assertFalse(sessionFactory == null);
       Session session = sessionFactory.openSession();
       Assert.assertTrue(session.isOpen());
       Assert.assertTrue(session.isConnected());
       sessionFactory.close();
   }

}
