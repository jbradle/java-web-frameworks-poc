package cz.jbradle.poc.web.spring.app.service;


import cz.jbradle.poc.web.spring.app.model.CategoryDTO;
import cz.jbradle.poc.web.spring.app.model.Framework;
import cz.jbradle.poc.web.spring.app.model.FrameworkDTO;
import cz.jbradle.poc.web.spring.app.persistence.CategoryRepository;
import cz.jbradle.poc.web.spring.app.persistence.FrameworkRepository;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Implementation of framework service
 * <p>
 * Created by George on 5.12.2015.
 */
@Service
class FrameworkServiceImpl implements FrameworkService {

    @Autowired
    private FrameworkRepository frameworkRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private MapperFacade mapper;

    @Override
    public List<FrameworkDTO> getAllFrameworks() {
        return mapper.mapAsList(frameworkRepository.findAllFetchCategoryOrderByAddedOn(), FrameworkDTO.class);
    }

    @Override
    public FrameworkDTO getFrameworkById(int id) {
        return mapper.map(frameworkRepository.findOne(id), FrameworkDTO.class);
    }


    @Override
    @Transactional
    public void removeFramework(int id) {
        frameworkRepository.delete(id);
    }

    @Override
    @Transactional
    public void saveFramework(FrameworkDTO frameworkWithChanges) {
        Framework framework;
        if (frameworkWithChanges.getId() == null) {
            framework = new Framework();
            framework.setAddedOn(new Date());
        } else {
            framework = frameworkRepository.findOne(frameworkWithChanges.getId());
        }
        framework.setName(frameworkWithChanges.getName());
        framework.setDescription(frameworkWithChanges.getDescription());
        framework.setCategory(categoryRepository.findOne(frameworkWithChanges.getCategoryId()));
        framework.setDocumentationLink(frameworkWithChanges.getDocumentationLink());
        frameworkRepository.save(framework);
    }


    @Override
    public List<FrameworkDTO> searchFrameworks(String searchParam) {
        if (searchParam != null) {
            return mapper.mapAsList(frameworkRepository.findByNameContainingIgnoreCaseOrderByAddedOn(searchParam), FrameworkDTO.class);
        }
        return mapper.mapAsList(frameworkRepository.findAllFetchCategoryOrderByAddedOn(), FrameworkDTO.class);
    }

    @Override
    public List<CategoryDTO> getAllCategoryNames() {
        return mapper.mapAsList(categoryRepository.findAll(), CategoryDTO.class);
    }
}
