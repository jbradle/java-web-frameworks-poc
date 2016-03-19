package cz.jbradle.poc.web.spring.app.mapping;

import cz.jbradle.poc.web.spring.app.model.Framework;
import cz.jbradle.poc.web.spring.app.model.FrameworkDTO;
import cz.jbradle.poc.web.spring.app.persistence.CategoryRepository;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Custom Framework mapper
 * <p>
 * Created by JBradle on 26.11.2015.
 */
@Component
class CustomFrameworkMapper extends CustomMapper<Framework, FrameworkDTO> {

    @Autowired
    private CategoryRepository categoryRepository;

	@Override
	public void mapBtoA(FrameworkDTO frameworkDTO, Framework framework,	MappingContext context) {
        framework.setCategory(categoryRepository.getOne(frameworkDTO.getCategoryId()));
	}
}
