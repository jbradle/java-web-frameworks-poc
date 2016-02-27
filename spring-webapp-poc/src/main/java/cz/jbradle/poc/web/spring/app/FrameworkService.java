package cz.jbradle.poc.web.spring.app;

import cz.jbradle.poc.web.spring.model.CategoryDTO;
import cz.jbradle.poc.web.spring.model.FrameworkDTO;

import java.util.List;

/**
 * Framework service interface
 *
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
