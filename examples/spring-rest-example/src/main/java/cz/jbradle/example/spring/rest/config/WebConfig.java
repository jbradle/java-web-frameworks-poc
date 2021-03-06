package cz.jbradle.example.spring.rest.config;

import cz.jbradle.example.spring.rest.controller.RestExampleController;
import cz.jbradle.example.spring.rest.view.JsonViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;

@Configuration
@ComponentScan(basePackageClasses = RestExampleController.class)
class WebConfig {

	@Bean
	public ViewResolver jsonViewResolver(){
		return new JsonViewResolver();
	}

}
