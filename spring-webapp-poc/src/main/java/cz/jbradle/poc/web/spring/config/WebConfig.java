package cz.jbradle.poc.web.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;

/**
 * Servlet configuration root class
 * <p/>
 * Created by George on 5.12.2015.
 */
@EnableWebMvc
@Configuration
@Import({ThymeleafConfig.class, PersistenceConfig.class})
@ComponentScan(basePackages = "cz.jbradle.poc.web.spring.app")
public class WebConfig extends WebMvcConfigurerAdapter {

    private static final String[] RESOURCES = {"img", "css", "js", "fonts", "font-awesome"};

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        for (String resource : RESOURCES) {
            addResource(registry, resource);
        }
    }

    private void addResource(ResourceHandlerRegistry registry, String resource) {
        registry.addResourceHandler("/resources/" + resource + "/**")
                .addResourceLocations("/resources/" + resource + "/");
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
