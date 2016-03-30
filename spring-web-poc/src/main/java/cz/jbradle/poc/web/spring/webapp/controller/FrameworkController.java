package cz.jbradle.poc.web.spring.webapp.controller;

import cz.jbradle.poc.web.spring.app.model.FrameworkDTO;
import cz.jbradle.poc.web.spring.app.service.FrameworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("frameworks", service.getAllFrameworks());
        return "index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAddFramework(ModelMap modelMap) {
        modelMap.addAttribute("framework", new FrameworkDTO());
        modelMap.addAttribute("categories", service.getAllCategories());
        return "add";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String addFramework(@ModelAttribute("framework") FrameworkDTO framework) {
        service.saveFramework(framework);
        return "redirect:/";
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
        modelMap.addAttribute("categories", service.getAllCategories());
        return "edit";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam("id") int id) {
        service.removeFramework(id);
        return "redirect:/";
    }


}
