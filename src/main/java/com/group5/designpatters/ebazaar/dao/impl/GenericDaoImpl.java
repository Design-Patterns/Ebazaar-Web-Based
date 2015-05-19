/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.designpatters.ebazaar.dao.impl;

import com.group5.designpatters.ebazaar.dao.GenericDao;
import com.group5.designpatters.ebazaar.utilities.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author Odiljon Sattarov
 */
public class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {

    protected SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<T> findAll(Class<T> entityClass) {
        sessionFactory.openSession().getTransaction();
        List<T> list = sessionFactory.getCurrentSession().createQuery("from " + entityClass.getName()).list();
        sessionFactory.getCurrentSession().getTransaction().commit();
        return list;
    }

    @Override
    public T findById(PK id, Class<T> entityClass) {
        sessionFactory.openSession().getTransaction();
        T t = (T) sessionFactory.getCurrentSession().get(entityClass, id);
        sessionFactory.getCurrentSession().getTransaction().commit();
        return t;
    }

    @Override
    public T create(T t) {
        sessionFactory.openSession().getTransaction();
        sessionFactory.getCurrentSession().persist(t);
        sessionFactory.getCurrentSession().getTransaction().commit();
        return t;
    }

    @Override
    public T update(T t) {
        sessionFactory.openSession().getTransaction();
        t = (T) sessionFactory.getCurrentSession().merge(t);
        sessionFactory.getCurrentSession().update(t);
        sessionFactory.getCurrentSession().getTransaction().commit();
        return t;
    }

    @Override
    public void delete(T t) {
        sessionFactory.openSession().getTransaction();
        t = (T) sessionFactory.getCurrentSession().merge(t);
        sessionFactory.getCurrentSession().delete(t);
        sessionFactory.getCurrentSession().getTransaction().commit();
    }

    @Override
    public T load(PK id, Class<T> entityClass) {
        sessionFactory.openSession().getTransaction();
        T t = (T) sessionFactory.getCurrentSession().load(entityClass, id);
        sessionFactory.getCurrentSession().getTransaction().commit();
        return t;
    }
}
