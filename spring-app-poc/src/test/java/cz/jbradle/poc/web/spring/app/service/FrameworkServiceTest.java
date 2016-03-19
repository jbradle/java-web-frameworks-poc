package cz.jbradle.poc.web.spring.app.service;


import cz.jbradle.poc.web.spring.app.model.CategoryDTO;
import cz.jbradle.poc.web.spring.app.model.FrameworkDTO;
import cz.jbradle.poc.web.spring.config.AppTestConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Framework service test
 * <p>
 * Created by JBradle on 28.2.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppTestConfig.class)
public class FrameworkServiceTest {

    private static final String TEST_FRAMEWORK = "Test framework";

    @Autowired
    private FrameworkService service;

    @Test
    public void testGetAllFrameworks(){
        assertFrameworkCount(3);
    }

    @Test
    public void testGetFrameworkById(){
        List<FrameworkDTO> frameworks = service.getAllFrameworks();
        for (FrameworkDTO framework : frameworks) {
            FrameworkDTO frameworkById = service.getFrameworkById(framework.getId());
            Assert.assertEquals("Framework found by id not equals.", framework, frameworkById);
        }
    }

    @Test
    public void testRemoveFramework(){
        assertFrameworkCount(4);
        service.removeFramework(1);
        service.removeFramework(2);
        assertFrameworkCount(2);
    }

    @Test
    public void testSaveFramework(){
        int countBefore = service.getAllFrameworks().size();
        FrameworkDTO frameworkDTO = new FrameworkDTO();
        frameworkDTO.setName(TEST_FRAMEWORK);
        frameworkDTO.setCategoryId(1);
        service.saveFramework(frameworkDTO);
        int countAfter = service.getAllFrameworks().size();
        Assert.assertTrue("Framework not properly saved.", countAfter - countBefore == 1);
    }

    @Test
    public void testSearchFrameworks(){
        List<FrameworkDTO> frameworks = service.searchFrameworks("Spring");
        Assert.assertFalse("Search not successful.", frameworks.isEmpty());
    }

    @Test
    public void testGetAllCategories(){
        List<CategoryDTO> categories = service.getAllCategories();
        Assert.assertTrue("Count of categories should be 4", categories.size() == 4);
    }

    private void assertFrameworkCount(int count){
        List<FrameworkDTO> frameworks = service.getAllFrameworks();
        Assert.assertTrue("Count of frameworks should be " + count, frameworks.size() == count);
    }
}