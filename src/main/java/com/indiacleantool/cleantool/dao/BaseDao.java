package com.indiacleantool.cleantool.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public abstract class BaseDao {

    @PersistenceContext
    private EntityManager entityManager;

    protected EntityManager getEntityManager(){
        return this.entityManager;
    }

    protected Session getSession(){
        return getEntityManager().unwrap(Session.class);
    }

    protected SessionFactory getSessionFactory(){
        Session session = this.getSession();
        return session.getSessionFactory();
    }

}
