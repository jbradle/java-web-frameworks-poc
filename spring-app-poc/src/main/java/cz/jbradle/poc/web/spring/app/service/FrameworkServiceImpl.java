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

import java.util.List;

/**
 * Implementation of framework service
 * <p>
 * Created by JBradle on 5.12.2015.
 */
@Service
@Transactional(readOnly = true)
class FrameworkServiceImpl implements FrameworkService {

    @Autowired
    private FrameworkRepository frameworkRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private MapperFacade mapper;

    @Override
    public List<FrameworkDTO> getAllFrameworks() {
        return mapper.mapAsList(frameworkRepository.findAllFetchCategoryOrderByName(), FrameworkDTO.class);
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
        Framework framework = mapper.map(frameworkWithChanges, Framework.class);
        frameworkRepository.save(framework);
    }


    @Override
    public List<FrameworkDTO> searchFrameworks(String searchParam) {
        if (searchParam != null) {
            return mapper.mapAsList(frameworkRepository.findByNameContainingIgnoreCaseOrderByName(searchParam), FrameworkDTO.class);
        }
        return mapper.mapAsList(frameworkRepository.findAllFetchCategoryOrderByName(), FrameworkDTO.class);
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return mapper.mapAsList(categoryRepository.findAll(), CategoryDTO.class);
    }
}
