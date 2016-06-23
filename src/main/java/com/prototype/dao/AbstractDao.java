package com.prototype.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractDao<T> {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    private final Class<T> clazz = (Class<T>) ((ParameterizedType) getClass()
    .getGenericSuperclass()).getActualTypeArguments()[0];

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void persist(T entity) {
        getSession().persist(entity);
    }

    public void delete(T entity) {
        getSession().delete(entity);
    }

    public List<T> findAll() {
        {
            Criteria criteria = getSession().createCriteria(clazz);
            return (List<T>) criteria.list();
        }
    }

    public T findById(Integer id) {
        Criteria criteria = getSession().createCriteria(clazz);
        criteria.add(Restrictions.eq("id", id));
        return (T) criteria.uniqueResult();
    }

    public void update(T role) {
        getSession().update(role);
    }
}
