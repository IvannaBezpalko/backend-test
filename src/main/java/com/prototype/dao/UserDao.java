package com.prototype.dao;

import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * Created by Ivanna on 22.05.2016.
 */
public interface UserDao {

    void persist(User user);

    List<User> findAll();

    User findById(Integer id);

    void update(User user);

    void delete(User user);

//    Set<Role> getRoles(Integer id);
}
