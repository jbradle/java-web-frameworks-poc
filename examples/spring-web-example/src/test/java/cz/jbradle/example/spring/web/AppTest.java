package cz.jbradle.example.spring.web;

import cz.jbradle.example.spring.web.config.AppConfig;
import cz.jbradle.example.spring.web.model.ExampleEntity;
import cz.jbradle.example.spring.web.persistence.ExampleRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class AppTest {

	@Autowired
	private ExampleRepository repository;

	@Test
	public void initTest(){
		Assert.assertNotNull(repository);
	}

	@Test
	@Transactional
	public void repositoryTest(){
		ExampleEntity entity = new ExampleEntity();
		entity.setName("Example");
		repository.save(entity);

		List<ExampleEntity> dbEntities = repository.findAll();

		Assert.assertTrue(dbEntities.size() == 1);
		System.out.println(Arrays.toString(dbEntities.toArray()));

		dbEntities = repository.findByName("Example");

		Assert.assertTrue(dbEntities.size() == 1);
		System.out.println(Arrays.toString(dbEntities.toArray()));
	}

}
