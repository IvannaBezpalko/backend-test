package com.prototype.services;

import com.prototype.dao.Role;

import java.util.List;

/**
 * Created by Ivanna on 25.05.2016.
 */
public interface RoleService {

    void persist(Role role);

    List<Role> findAll();

    Role findById(Integer id);

    void update(Role role);

    void delete(Role role);
}
