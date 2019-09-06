package org.robatipoor.dao;

import java.io.Serializable;
import java.util.List;

/**
 * InterfaceDAO
 */
public interface InterfaceDAO<T, Id extends Serializable> {
    T findById(Id id);

    List<T> findAll();

    boolean save(T entity);

    boolean delete(T entity);

    boolean update(T entity);
}