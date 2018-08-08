package com.timothy.server.user.domain.dao;

import com.timothy.server.user.domain.model.EmgUser;
import com.timothy.server.user.domain.model.EmgUserRole;
import com.timothy.server.user.domain.model.EmgUserRoleImpl;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;


@Transactional
@Repository
public class EmgUserDaoImpl implements EmgUserDao {


    @PersistenceContext
    EntityManager em;

    @Override
    public List<EmgUser> findAll() throws Exception {

        Query q = em.createQuery("select e from EmgUser e ");
        return q.getResultList();

    }

    @Override
    public EmgUser findByUserName(String userName) throws Exception {

        Query q = em.createQuery("select e from EmgUser e where e.userName IN:userName")
                .setParameter("userName", userName.toLowerCase());
        return (EmgUser) q.getResultList().get(0);

    }

    @Override
    public EmgUser findByUserId(Long userId) throws Exception {

        Query q = em.createQuery("select e from EmgUser e where e.userId IN:userID")
                .setParameter("userID", userId);
        return (EmgUser) q.getResultList().get(0);

    }


    @Override
    public EmgUser save(EmgUser user) throws Exception {

        user.setCreatedAt(Timestamp.from(Instant.now()));
        em.persist(user);
        return findByUserName(user.getUsername());

    }

    @Override
    public void setUserRole(long uId, long roleId) throws Exception {
        EmgUserRole role = new EmgUserRoleImpl();
        role.setCreatedAt(Timestamp.from(Instant.now()));
        role.setAccessLevelId(roleId);
        role.setUserId(uId);
        em.persist(role);
    }
}
