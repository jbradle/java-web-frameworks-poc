package cz.jbradle.poc.web.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Servlet configuration root class
 * <p/>
 * Created by George on 5.12.2015.
 */
@EnableWebMvc
@Configuration
@Import({ThymeleafConfig.class})
@ComponentScan(basePackages = "cz.jbradle.poc.web.spring.controller")
class ServletConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/favicon.ico").addResourceLocations("/resources/img/favicon.ico");
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        registry.addResourceHandler("/node_modules/**").addResourceLocations("/node_modules/");
    }
}
