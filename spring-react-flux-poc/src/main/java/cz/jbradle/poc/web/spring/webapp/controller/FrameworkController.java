package cz.jbradle.poc.web.spring.webapp.controller;

import cz.jbradle.poc.web.spring.app.model.CategoryDTO;
import cz.jbradle.poc.web.spring.app.model.FrameworkDTO;
import cz.jbradle.poc.web.spring.app.service.FrameworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Rest framework controller
 *
 * Created by George on 20.3.2016.
 */
@RestController
@RequestMapping("rest/")
class FrameworkController {


    @Autowired
    private FrameworkService service;

    @RequestMapping(value = "/getAllFrameworks")
    public List<FrameworkDTO> getAllFrameworks() {
        return service.getAllFrameworks();
    }

	@RequestMapping(value = "/getAllCategories")
	public List<CategoryDTO> getAllCategories() {
		return service.getAllCategories();
	}


	@RequestMapping(value = "/searchFrameworks", method = RequestMethod.GET)
	public List<FrameworkDTO> search(@RequestParam(name = "searchParam", required = false) String searchParam) {
		return service.searchFrameworks(searchParam);
	}
}
