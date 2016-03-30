package cz.jbradle.example.spring.rest.persistence;

import cz.jbradle.example.spring.rest.model.ExampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExampleRepository
        extends JpaRepository<ExampleEntity, Integer> {

    List<ExampleEntity> findByValue(String value);

    @Query("select e from ExampleEntity e where e.value = :value")
    List<ExampleEntity> findByQuery(@Param("value") String value);
}

