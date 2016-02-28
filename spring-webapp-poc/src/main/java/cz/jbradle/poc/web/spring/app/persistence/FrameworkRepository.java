package cz.jbradle.poc.web.spring.app.persistence;

import cz.jbradle.poc.web.spring.app.model.Framework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Framework repository
 * <p>
 * Created by George on 5.12.2015.
 */
public interface FrameworkRepository extends JpaRepository<Framework, Integer> {

    List<Framework> findByNameContainingIgnoreCaseOrderByAddedOn(String searchPattern);

    @Query("select f from Framework f join fetch f.category order by f.addedOn desc")
    List<Framework> findAllFetchCategoryOrderByAddedOn();
}