/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.designpatters.ebazaar.dao;

import java.util.List;

/**
 *
 * @author Odiljon Sattarov
 */
public interface GenericDao<T, PK> {

    List<T> findAll(Class<T> entityClass);

    T findById(PK id, Class<T> entityClass);

    T create(T t);

    T update(T t);

    void delete(T t);

    T load(PK id, Class<T> entityClass);
}
