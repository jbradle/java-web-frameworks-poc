package cz.jbradle.poc.web.spring.app.controller;

import cz.jbradle.poc.web.spring.app.service.FrameworkService;
import cz.jbradle.poc.web.spring.model.Framework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * Frameworks controller
 *
 * Created by George on 5.12.2015.
 */
@Controller
class FrameworkController {

    @Autowired
    private FrameworkService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "about";
    }

    @RequestMapping(value = "/example", method = RequestMethod.GET)
    public String about(ModelMap modelMap) {
        modelMap.addAttribute("frameworks", service.getAllFrameworks());
        return "index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAddFramework(ModelMap modelMap) {
        modelMap.addAttribute("framework", new Framework());
        modelMap.addAttribute("categories", service.getAllCategoryNames());
        return "add";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(@RequestParam(name = "searchParam", required = false) String searchParam, ModelMap modelMap) {
        modelMap.addAttribute("frameworks", service.searchFrameworks(searchParam));
        return "search";
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable int id, ModelMap modelMap) {
        modelMap.addAttribute("framework", service.getFrameworkById(id));
        return "detail";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable int id, ModelMap modelMap) {
        modelMap.addAttribute("framework", service.getFrameworkById(id));
        modelMap.addAttribute("categories", service.getAllCategoryNames());
        return "edit";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam("id") int id) {
        service.removeFramework(id);
        return "redirect:/example";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String addFramework(@ModelAttribute("framework") Framework framework) {
        service.saveFramework(framework);
        return "redirect:/example";
    }

}
