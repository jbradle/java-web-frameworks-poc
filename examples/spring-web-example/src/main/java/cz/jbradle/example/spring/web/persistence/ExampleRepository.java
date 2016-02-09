package cz.jbradle.example.spring.web.persistence;

import cz.jbradle.example.spring.web.model.ExampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExampleRepository extends JpaRepository<ExampleEntity, Integer> {

	List<ExampleEntity> findByName(String name);

}
