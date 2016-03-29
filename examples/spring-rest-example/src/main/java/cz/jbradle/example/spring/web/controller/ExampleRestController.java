package cz.jbradle.example.spring.web.controller;

import cz.jbradle.example.spring.web.model.ExampleEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class ExampleRestController {

	@RequestMapping(value = "/example", method = RequestMethod.GET)
	public ExampleEntity example() {
		return new ExampleEntity(1, "Example value");
	}
}
