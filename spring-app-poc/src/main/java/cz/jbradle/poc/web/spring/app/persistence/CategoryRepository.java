package cz.jbradle.poc.web.spring.app.persistence;

import cz.jbradle.poc.web.spring.app.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Category repository
 * <p>
 * Created by JBradle on 5.12.2015.
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
