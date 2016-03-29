package cz.jbradle.example.spring.web.config;

import cz.jbradle.example.spring.web.controller.ExampleController;
import cz.jbradle.example.spring.web.view.JsonViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;

@Configuration
@ComponentScan(basePackageClasses = ExampleController.class)
class WebConfig {

	@Bean
	public ViewResolver jsonViewResolver(){
		return new JsonViewResolver();
	}

}
