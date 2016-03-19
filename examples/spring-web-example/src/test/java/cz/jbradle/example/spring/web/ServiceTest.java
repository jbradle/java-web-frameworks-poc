package cz.jbradle.example.spring.web;

import cz.jbradle.example.spring.web.config.ServiceTestConfig;
import cz.jbradle.example.spring.web.service.ExampleService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

@ContextConfiguration(classes = {ServiceTestConfig.class})
public class ServiceTest extends StringTest{

    @Autowired
    private ExampleService service;

    @Test
    public void initTest() {
        Assert.assertNotNull(service);
    }

    @Test
    public void serviceTest() {
        List<String> values = service.getAllValues();
        Assert.assertTrue(values.size() == 4);
        System.out.println(Arrays.toString(values.toArray()));
    }

}
