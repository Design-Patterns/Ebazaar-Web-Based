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
import org.hibernate.Transaction;

/**
 *
 * @author Odiljon Sattarov
 */
public class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<T> findAll(Class<T> entityClass) {
        return sessionFactory.getCurrentSession().createQuery("from " + entityClass.getName()).list();
    }

    @Override
    public T findById(PK id, Class<T> entityClass) {
        return (T) sessionFactory.getCurrentSession().get(entityClass, id);
    }

    @Override
    public T create(T t) {
        sessionFactory.getCurrentSession().persist(t);
        return t;
    }

    @Override
    public T update(T t) {
        t = (T) sessionFactory.getCurrentSession().merge(t);
        sessionFactory.getCurrentSession().update(t);
        return t;
    }

    @Override
    public void delete(T t) {
        t = (T) sessionFactory.getCurrentSession().merge(t);
        sessionFactory.getCurrentSession().delete(t);
    }

    @Override
    public T load(PK id, Class<T> entityClass) {
        return (T) sessionFactory.getCurrentSession().load(entityClass, id);
    }
}
