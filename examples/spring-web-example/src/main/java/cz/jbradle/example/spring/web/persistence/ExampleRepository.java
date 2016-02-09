package cz.jbradle.example.spring.web.persistence;

import cz.jbradle.example.spring.web.model.ExampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExampleRepository extends JpaRepository<ExampleEntity, Integer> {

}
