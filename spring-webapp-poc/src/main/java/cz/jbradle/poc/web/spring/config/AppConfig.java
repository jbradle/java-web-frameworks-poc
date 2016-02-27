package cz.jbradle.poc.web.spring.config;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;

/**
 * Servlet configuration root class
 * <p>
 * Created by George on 5.12.2015.
 */
@Configuration
@Import({PersistenceConfig.class})
@ComponentScan(basePackages = "cz.jbradle.poc.web.spring.app")
class AppConfig extends WebMvcConfigurerAdapter {

    @Bean
    public MapperFacade mapperFacade(){
        return new ConfigurableMapper();
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
