package cz.jbradle.poc.web.spring.app;

import cz.jbradle.poc.web.spring.model.Category;
import cz.jbradle.poc.web.spring.model.Framework;
import cz.jbradle.poc.web.spring.persistence.CategoryRepository;
import cz.jbradle.poc.web.spring.persistence.FrameworkRepository;
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
@Transactional(readOnly = true)
class FrameworkServiceImpl implements FrameworkService {

    @Autowired
    private FrameworkRepository frameworkRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Framework> getAllFrameworks() {
        return frameworkRepository.findAllFetchCategoryOrderByAddedOn();
    }

    @Override
    public Framework getFrameworkById(int id) {
        return frameworkRepository.findOne(id);
    }


    @Override
    @Transactional
    public void removeFramework(int id) {
        frameworkRepository.delete(id);
    }

    @Override
    @Transactional
    public void saveFramework(Framework frameworkWithChanges) {
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
    public List<Framework> searchFrameworks(String searchParam) {
        if (searchParam != null) {
            return frameworkRepository.findByNameContainingIgnoreCaseOrderByAddedOn(searchParam);
        }
        return frameworkRepository.findAllFetchCategoryOrderByAddedOn();
    }

    @Override
    public List<Category> getAllCategoryNames() {
        return categoryRepository.findAll();
    }
}
