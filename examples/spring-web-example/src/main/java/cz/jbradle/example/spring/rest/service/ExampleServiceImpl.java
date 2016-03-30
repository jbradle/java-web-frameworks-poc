package cz.jbradle.example.spring.rest.service;

import cz.jbradle.example.spring.rest.model.ExampleEntity;
import cz.jbradle.example.spring.rest.persistence.ExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
class ExampleServiceImpl implements ExampleService {

    @Autowired
    private ExampleRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<String> getAllValues() {
        return repository.findAll()
                .stream()
                .map(ExampleEntity::getValue)
                .collect(Collectors.toList());
    }
}
