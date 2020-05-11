package com.ulyssesk.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
    void save(T entity);
    void update(T entity);
    void delete(Serializable... ids);
    T find(Serializable id);
    List<T> findAll();
    List<T> findAll(String order);
    List<T> findByProp(String propName,Object value);
    List<T> findByProp(String propName,Object value,String order);
    List<T> findByProps(String[] propName,Object[] values);
    List<T> findByProps(String[] propName,Object[] values,String order);
    T uniqueByProp(String propName,Object value);
    T uniqueByProps(String[] propName,Object[] values);
    int countByCondition(String[] params,Object[] values);
}
