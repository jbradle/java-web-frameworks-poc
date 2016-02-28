package cz.jbradle.poc.web.spring.app.service;

import cz.jbradle.poc.web.spring.app.model.CategoryDTO;
import cz.jbradle.poc.web.spring.app.model.FrameworkDTO;

import java.util.List;

/**
 * Framework service interface
 * <p>
 * Created by George on 5.12.2015.
 */
public interface FrameworkService {

    List<FrameworkDTO> getAllFrameworks();

    FrameworkDTO getFrameworkById(int id);

    void removeFramework(int id);

    void saveFramework(FrameworkDTO framework);

    List<FrameworkDTO> searchFrameworks(String searchParam);

    List<CategoryDTO> getAllCategoryNames();
}
