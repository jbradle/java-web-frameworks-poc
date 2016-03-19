package cz.jbradle.poc.web.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Configuration class to access package private configuration
 *
 * Created by JBradle on 28.2.2016.
 */
@Configuration
@Import(AppConfig.class)
public class AppTestConfig {
}
