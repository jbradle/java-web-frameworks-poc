package cz.jbradle.poc.web.spring.config;

import cz.jbradle.poc.web.spring.app.mapping.ContextAwareMapperBean;
import ma.glasnost.orika.MapperFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Servlet configuration root class
 * <p>
 * Created by JBradle on 5.12.2015.
 */
@Configuration
@EnableTransactionManagement
@Import({PersistenceConfig.class})
@ComponentScan(basePackages = "cz.jbradle.poc.web.spring.app")
class AppConfig {

    @Bean
    public MapperFacade mapperFacade() {
        return new ContextAwareMapperBean();
    }

    @Bean
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder
                .setType(EmbeddedDatabaseType.H2)
                .addScript("sql/create-db.sql")
                .build();
    }
}
