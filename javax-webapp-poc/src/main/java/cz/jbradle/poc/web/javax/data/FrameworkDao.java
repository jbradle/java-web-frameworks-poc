package cz.jbradle.poc.web.javax.data;

import cz.jbradle.poc.web.javax.model.Framework;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Implementation of data access object for work with frameworks data
 * <p/>
 * Created by George on 7.11.2015.
 */
@Stateless
public class FrameworkDao implements FrameworkDaoRemote {

    @PersistenceUnit(unitName = "frameworks-unit")
    private EntityManagerFactory entityManagerFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<Framework> getAllFrameworks() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Framework> frameworkList = entityManager.createQuery("select fw from Framework fw").getResultList();
        entityManager.close();
        return frameworkList;
    }

    @Override
    public void addFramework(Framework framework) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        framework.setId(getNextId(entityManager));
        entityManager.persist(framework);
        entityManager.close();
    }

    @Override
    public void updateFramework(Framework framework) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.merge(framework);
        entityManager.close();
    }

    @Override
    public Framework getById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select fw from Framework fw where fw.id = :id");
        query.setParameter("id", id);
        Framework result = (Framework) query.getSingleResult();
        entityManager.close();
        return result;
    }

    @Override
    public void deleteFramework(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("delete from Framework fw where fw.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
        entityManager.close();
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<Framework> searchFrameworksByName(String searchParam) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select fw from Framework fw where fw.name like :name");
        query.setParameter("name", "%" + searchParam + "%");
        List<Framework> frameworkList = query.getResultList();
        entityManager.close();
        return frameworkList;
    }



    private int getNextId(EntityManager entityManager) {
        Query query = entityManager.createQuery("select max(fw.id) from Framework fw");
        Object result = query.getSingleResult();
        return (int) result + 1;
    }
}
