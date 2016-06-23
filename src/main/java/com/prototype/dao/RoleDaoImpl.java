package com.prototype.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Ivanna on 25.05.2016.
 */
@Repository("roleDao")
public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao{

}
