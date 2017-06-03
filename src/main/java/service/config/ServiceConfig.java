package service.config;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    /**
     * Bean necessary to convert model to json
     */
    @Bean
    public Module datatypeHibernateModule() {
        return new Hibernate5Module();
    }
}
