package cz.jbradle.example.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class ExampleController {

    @RequestMapping("/example")
    public String example(Model model) {
        model.addAttribute("modelAttributeName", "example value");
        return "example";
    }
}
