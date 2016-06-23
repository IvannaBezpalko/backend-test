package com.prototype.dao;

import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<User> implements UserDao {

//    @Autowired
//    private SessionFactory sessionFactory;
//
//    protected Session getSession() {
//        return sessionFactory.getCurrentSession();
//    }
//
//    public Set<Role> getRoles(Integer id){
//        Criteria criteria = getSession().createCriteria(User.class);
//        criteria.add(Restrictions.eq("id", id));
//        User user = (User) criteria.uniqueResult();
//        return user.getRoles();
//    }
}
