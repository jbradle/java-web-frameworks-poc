package cz.jbradle.example.spring.web.persistence;

import cz.jbradle.example.spring.web.model.ExampleEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExampleRepository extends Repository<ExampleEntity, Integer> {

	void save(ExampleEntity exampleEntity);

	List<ExampleEntity> findByValue(String name);

	@Query("select e from ExampleEntity e where e.value = :value")
	List<ExampleEntity> findByValueAnnotation(@Param("value") String value);

}
