package com.prototype.services;

import com.prototype.dao.Role;
import com.prototype.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao dao;

    public void persist(Role role) {
        dao.persist(role);
    }

    public List<Role> findAll() {
        return dao.findAll();
    }

    public Role findById(Integer id) {
        return dao.findById(id);
    }

    public void update(Role role) {
        dao.update(role);
    }

    public void delete(Role role) {
        dao.delete(role);
    }
}
