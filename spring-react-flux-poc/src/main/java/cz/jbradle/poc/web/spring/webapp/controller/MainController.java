package cz.jbradle.poc.web.spring.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Frameworks controller
 * <p>
 * Created by JBradle on 5.12.2015.
 */
@Controller
class MainController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String home() {
        return "index";
    }

}