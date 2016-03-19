package cz.jbradle.example.spring.web;

import cz.jbradle.example.spring.web.config.RepositoryTestConfig;
import cz.jbradle.example.spring.web.model.ExampleEntity;
import cz.jbradle.example.spring.web.persistence.ExampleRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.Arrays;
import java.util.List;


@ContextConfiguration(classes = {RepositoryTestConfig.class})
public class RepositoryTest extends StringTest {

    @Autowired
    private ExampleRepository repository;

    @Test
    public void initTest() {
        Assert.assertNotNull(repository);
    }

    @Test
    public void repositoryTest() {
        ExampleEntity entity = new ExampleEntity();
        entity.setValue("example-value");
        repository.save(entity);

        List<ExampleEntity> dbEntities = repository.findAll();

        Assert.assertTrue(dbEntities.size() == 5);
        System.out.println(Arrays.toString(dbEntities.toArray()));

        dbEntities = repository.findByValue("example-value");

        Assert.assertTrue(dbEntities.size() == 1);
        System.out.println(Arrays.toString(dbEntities.toArray()));

        dbEntities = repository.findByQuery("example-value");

        Assert.assertTrue(dbEntities.size() == 1);
        System.out.println(Arrays.toString(dbEntities.toArray()));
    }

}
