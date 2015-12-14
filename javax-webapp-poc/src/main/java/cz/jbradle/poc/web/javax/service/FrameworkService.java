package cz.jbradle.poc.web.javax.service;

import cz.jbradle.poc.web.javax.data.FrameworkDaoRemote;
import cz.jbradle.poc.web.javax.model.Framework;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Implementation of service for operations with frameworks as singleton
 * <p>
 * Created by George on 7.11.2015.
 */
@Stateless
@Transactional
public class FrameworkService implements FrameworkServiceRemote{

    @EJB
    private FrameworkDaoRemote frameworkDao;


    public List<Framework> getAllFrameworks() {
        return frameworkDao.getAllFrameworks();
    }

    public void addFramework(String name, String description, String category, String documentationLink) {
        Framework framework = new Framework(name, description, category, documentationLink, new Date());
        frameworkDao.addFramework(framework);
    }

    @Override
    public List<Framework> searchFrameworks(String searchParam) {
        return frameworkDao.searchFrameworksByName(searchParam);
    }

    public Framework getFrameworkById(int id) {
        return frameworkDao.getById(id);
    }

    public void updateFramework(int id, String name, String description, String category, String docLink) {
        Framework framework = frameworkDao.getById(id);
        framework.setName(name);
        framework.setDescription(description);
        framework.setCategory(category);
        framework.setDocumentationLink(docLink);
        frameworkDao.updateFramework(framework);
    }

    public void removeFramework(int id){
        frameworkDao.deleteFramework(id);
    }
}
