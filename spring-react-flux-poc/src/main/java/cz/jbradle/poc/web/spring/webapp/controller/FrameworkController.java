package cz.jbradle.poc.web.spring.webapp.controller;

import cz.jbradle.poc.web.spring.app.model.CategoryDTO;
import cz.jbradle.poc.web.spring.app.model.FrameworkDTO;
import cz.jbradle.poc.web.spring.app.service.FrameworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

	@RequestMapping(value = "/saveFramework", method = RequestMethod.POST)
	public List<FrameworkDTO> addFramework(@RequestBody FrameworkDTO framework) {
		service.saveFramework(framework);
		return service.getAllFrameworks();
	}

    @RequestMapping(value = "/deleteFramework", method = RequestMethod.DELETE)
    public List<FrameworkDTO> deleteFramework(@RequestBody FrameworkDTO framework) {
        service.removeFramework(framework.getId());
        return service.getAllFrameworks();
    }
}
