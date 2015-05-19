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

    protected SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<T> findAll(Class<T> entityClass) {
        Transaction tx = sessionFactory.getCurrentSession().getTransaction();
        List<T> list = sessionFactory.getCurrentSession().createQuery("from " + entityClass.getName()).list();
        tx.commit();
        return list;
    }

    @Override
    public T findById(PK id, Class<T> entityClass) {
        Transaction tx = sessionFactory.getCurrentSession().getTransaction();
        T t = (T) sessionFactory.getCurrentSession().get(entityClass, id);
        tx.commit();
        return t;
    }

    @Override
    public T create(T t) {
        Transaction tx = sessionFactory.getCurrentSession().getTransaction();
        sessionFactory.getCurrentSession().persist(t);
        tx.commit();
        return t;
    }

    @Override
    public T update(T t) {
        Transaction tx = sessionFactory.getCurrentSession().getTransaction();
        t = (T) sessionFactory.getCurrentSession().merge(t);
        sessionFactory.getCurrentSession().update(t);
        tx.commit();
        return t;
    }

    @Override
    public void delete(T t) {
        Transaction tx = sessionFactory.getCurrentSession().getTransaction();
        t = (T) sessionFactory.getCurrentSession().merge(t);
        sessionFactory.getCurrentSession().delete(t);
        tx.commit();
    }

    @Override
    public T load(PK id, Class<T> entityClass) {
        Transaction tx = sessionFactory.getCurrentSession().getTransaction();
        T t = (T) sessionFactory.getCurrentSession().load(entityClass, id);
        tx.commit();
        return t;
    }
}
