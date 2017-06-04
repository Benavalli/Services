package application;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration(exclude = {HibernateJpaAutoConfiguration.class})
@ComponentScan({"service", "data.dao", "data.hibernate.config",
        "controller", "data", "security"})
public class ApplicationWeb {}