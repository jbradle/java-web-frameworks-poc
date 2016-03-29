package cz.jbradle.example.spring.web.controller;

import cz.jbradle.example.spring.web.model.ExampleEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class ExampleRestController {

	@RequestMapping("/example")
	public ExampleEntity example() {
		return new ExampleEntity(1, "Example value");
	}
}
