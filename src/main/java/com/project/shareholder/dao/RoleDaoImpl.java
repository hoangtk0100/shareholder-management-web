package com.project.shareholder.dao;

import com.project.shareholder.common.CommonHibernate;
import com.project.shareholder.exception.DatabaseException;
import com.project.shareholder.model.Role;
import com.project.shareholder.util.Constants;
import org.hibernate.query.Query;

import java.util.UUID;

public class RoleDaoImpl extends CommonHibernate<Role> implements RoleDao {
    @Override
    public Role retrieveById(UUID id) throws DatabaseException {
        String sql = "from role r where r.id = :id";
        try {
            Query query = getCurrentSession().createQuery(sql, Role.class)
                    .setParameter("id", id);
            return (Role) query.getSingleResult();
        } catch (Exception exception) {
            throw new DatabaseException(Constants.DATABASE_MESSAGE);
        }
    }

    @Override
    public Role retrieveByName(String name) throws DatabaseException {
        String sql = "from role r where r.name = :name";
        try {
            Query query = getCurrentSession().createQuery(sql, Role.class)
                    .setParameter("name", name);
            return (Role) query.getSingleResult();
        } catch (Exception exception) {
            throw new DatabaseException(Constants.DATABASE_MESSAGE);
        }
    }

    @Override
    public String getTableName() {
        return "Role";
    }
}
