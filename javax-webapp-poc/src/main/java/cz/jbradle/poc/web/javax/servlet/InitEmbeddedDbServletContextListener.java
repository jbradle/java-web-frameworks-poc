package cz.jbradle.poc.web.javax.servlet;

import cz.jbradle.poc.web.javax.model.Framework;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Date;

/**
 * Context listener to load data to db
 *
 * Created by George on 8.11.2015.
 */
public class InitEmbeddedDbServletContextListener implements ServletContextListener{

    private EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("cz.jbradle.poc.web.javax");

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery(
                "create table FRAMEWORK (id integer not null, ADDED_ON timestamp, CATEGORY varchar(255), " +
                        "DESCRIPTION varchar, DOC_LINK varchar(255), NAME varchar(255), primary key (id))")
                .executeUpdate();
        entityManager.persist(new Framework(1, "Spring Web MVC", "Spring Web MVC", "Web Layer",
                "http://docs.spring.io/spring/docs/current/spring-framework-reference/html/beans.html", new Date()));
        entityManager.persist(new Framework(2, "Hibernate", "Hibernate", "Daata Layer",
                "http://hibernate.org/orm/documentation/5.0/", new Date()));
        entityManager.persist(new Framework(3, "Spring Beans", "Spring Beans", "Service Layer",
                "http://docs.spring.io/spring/docs/current/spring-framework-reference/html/beans.html", new Date()));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        entityManagerFactory.close();
    }
}
