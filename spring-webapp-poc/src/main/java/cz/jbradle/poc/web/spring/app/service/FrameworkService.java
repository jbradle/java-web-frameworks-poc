package cz.jbradle.poc.web.spring.app.service;

import cz.jbradle.poc.web.spring.model.Category;
import cz.jbradle.poc.web.spring.model.Framework;

import java.awt.*;
import java.util.List;

/**
 * Framework service interface
 *
 * Created by George on 5.12.2015.
 */
public interface FrameworkService {

    List<Framework> getAllFrameworks();

    Framework getFrameworkById(int id);

    void removeFramework(int id);

    void saveFramework(Framework framework);

    List<Framework> searchFrameworks(String searchParam);

    List<Category> getAllCategoryNames();
}
