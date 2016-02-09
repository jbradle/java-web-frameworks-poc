package cz.jbradle.poc.web.spring.persistence;

import cz.jbradle.poc.web.spring.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Category repository
 * <p>
 * Created by George on 5.12.2015.
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
