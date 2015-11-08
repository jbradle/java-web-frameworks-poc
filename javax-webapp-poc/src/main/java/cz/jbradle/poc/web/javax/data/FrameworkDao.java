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

    private EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("cz.jbradle.poc.web.javax");

    @Override
    @SuppressWarnings("unchecked")
    public List<Framework> getAllFrameworks() {
        EntityManager entityManager = getEntityManagerAndStartTransaction();
        List<Framework> frameworkList = entityManager.createQuery("select fw from Framework fw").getResultList();
        entityManager.close();
        return frameworkList;
    }

    @Override
    public void addFramework(Framework framework) {
        EntityManager entityManager = getEntityManagerAndStartTransaction();
        framework.setId(getNextId(entityManager));
        entityManager.persist(framework);
        commitAndCloseEntityManager(entityManager);
    }

    @Override
    public void updateFramework(Framework framework) {
        EntityManager entityManager = getEntityManagerAndStartTransaction();
        entityManager.merge(framework);
        commitAndCloseEntityManager(entityManager);
    }

    @Override
    public Framework getById(int id) {
        EntityManager entityManager = getEntityManagerAndStartTransaction();
        Query query = entityManager.createQuery("select fw from Framework fw where fw.id = :id");
        query.setParameter("id", id);
        Framework result = (Framework) query.getSingleResult();
        entityManager.close();
        return result;
    }

    @Override
    public void deleteFramework(int id) {
        EntityManager entityManager = getEntityManagerAndStartTransaction();
        Query query = entityManager.createQuery("delete from Framework fw where fw.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
        commitAndCloseEntityManager(entityManager);
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<Framework> searchFrameworksByName(String searchParam) {
        EntityManager entityManager = getEntityManagerAndStartTransaction();
        Query query = entityManager.createQuery("select fw from Framework fw where fw.name like :name");
        query.setParameter("name", "%" + searchParam + "%");
        List<Framework> frameworkList = query.getResultList();
        entityManager.close();
        return frameworkList;
    }


    private EntityManager getEntityManagerAndStartTransaction(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        return entityManager;
    }

    private void commitAndCloseEntityManager(EntityManager entityManager) {
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private int getNextId(EntityManager entityManager) {
        Query query = entityManager.createQuery("select max(fw.id) from Framework fw");
        Object result = query.getSingleResult();
        return (int) result + 1;
    }
}
