package cz.jbradle.poc.web.spring.webapp.controller;

import cz.jbradle.poc.web.spring.app.service.FrameworkService;
import cz.jbradle.poc.web.spring.app.model.FrameworkDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * Frameworks controller
 * <p>
 * Created by JBradle on 5.12.2015.
 */
@Controller
class FrameworkController {

    @Autowired
    private FrameworkService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }
}