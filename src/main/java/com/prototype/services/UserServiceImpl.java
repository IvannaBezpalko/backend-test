package com.prototype.services;

import com.prototype.dao.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prototype.dao.UserDao;
import com.prototype.dao.User;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao dao;

    public void persist(User user) {
        dao.persist(user);
    }

    public List<User> findAll() {
        return dao.findAll();
    }
    public User findById(Integer id) {
        return dao.findById(id);
    }

    public void update(User user){
        dao.update(user);
    }

    @Override
    public void delete(User user) {
        dao.delete(user);
    }

//    public Set<Role> getRoles(Integer id){
//        return dao.getRoles(id);
//    }
}