package com.prototype.services;

import com.prototype.dao.Role;
import com.prototype.dao.User;

import java.util.List;
import java.util.Set;

public interface UserService {

    void persist(User user);

    List<User> findAll();

    User findById(Integer id);

    void update(User user);

    void delete(User user);

//    Set<Role> getRoles(Integer id);
}
