package cz.jbradle.example.spring.rest.controller;

import cz.jbradle.example.spring.rest.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class RestExampleController {

    @Autowired
    private ExampleService service;

    @RequestMapping(value = "/example", method = RequestMethod.GET)
    public List<String> example() {
        return service.getAllValues();
    }
}
