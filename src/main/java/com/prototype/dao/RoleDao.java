package com.prototype.dao;

import java.util.List;
/**
 * Created by Ivanna on 25.05.2016.
 */
public interface RoleDao {

    void persist(Role role);

    List<Role> findAll();

    Role findById(Integer id);

    void update(Role role);

    void delete(Role role);
}
