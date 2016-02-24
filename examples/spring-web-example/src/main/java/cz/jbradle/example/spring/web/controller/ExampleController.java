package cz.jbradle.example.spring.web.controller;

import cz.jbradle.example.spring.web.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExampleController {

    @Autowired
    private ExampleService service;

    @RequestMapping("/example")
    public String example(Model model) {
        model.addAttribute("exampleValues", service.getAllValues());
        return "example";
    }
}
