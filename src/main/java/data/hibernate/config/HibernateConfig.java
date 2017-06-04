package data.hibernate.config;

import data.model.login.Login;
import data.model.userdetail.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import data.model.login.Password;
import data.model.login.User;
import java.io.IOException;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;

@Configuration 
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
public class HibernateConfig {

	@Value("${database.driverClassName}")
	private String driverClassName;

	@Value("${database.url}")
	private String dataBaseUrl;

	@Value("${database.username}")
	private String dataBaseUserName;

	@Value("${database.password}")
	private String dataBasePassword;

	@Value("${hibernate.dialect}")
	private String hibernateDialect;

	@Value("${hibernate.show_sql}")
	private String hibernateShowSql;

	@Value("${hibernate.format_sql}")
	private String hibernateFormatSql;
	
	@Bean
	public HibernateTemplate hibernateTemplate() {
		return new HibernateTemplate(sessionFactory());
	}
	
	@Bean
	public SessionFactory sessionFactory() {		
		LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
	    lsfb.setDataSource(getDataSource());
	    lsfb.setAnnotatedClasses(User.class, Password.class, Login.class, UserDetail.class);
	    lsfb.setHibernateProperties(hibernateProperties());
	    try {
	    	lsfb.afterPropertiesSet();
	    } 
	    catch (IOException e) {
		     e.printStackTrace();
	    }
	    return lsfb.getObject();		
	}
	
	@Bean
	public DataSource getDataSource() {
	    BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
	    dataSource.setUrl(dataBaseUrl);
	    dataSource.setUsername(dataBaseUserName);
	    dataSource.setPassword(dataBasePassword);
	    return dataSource;
	}
	
	@Bean
	public HibernateTransactionManager hibernateTransactionManager(){
		return new HibernateTransactionManager(sessionFactory());
	}
	
	private Properties hibernateProperties() {
         Properties properties = new Properties();
         properties.put("hibernate.dialect", hibernateDialect);
         properties.put("hibernate.show_sql", hibernateShowSql);
         properties.put("hibernate.format_sql",hibernateFormatSql);
         return properties;        
    }	

}
