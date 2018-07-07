package com.timothy.internship.M_identity.domain.dao;

import com.timothy.internship.M_core.EmgResponseStatus;
import com.timothy.internship.M_identity.domain.model.EmgActor;
import com.timothy.internship.M_identity.domain.model.EmgUser;
import com.timothy.internship.M_identity.domain.model.EmgUserRole;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class EmgUserDaoImpl implements EmgUserDao {

    @PersistenceContext
    private EntityManager em;

    private EmgResponseStatus res = new EmgResponseStatus();

    public EmgUserDaoImpl() {

    }


    @Override
    public EmgResponseStatus createPrincipal(EmgUser user) {
        try {

            em.persist(user);
            return OK();
        } catch (Exception e) {
            e.printStackTrace();
            return BAD(e.getMessage());
        }
    }

    @Override
    public EmgResponseStatus setPrincipalActor(EmgActor actorType) {

        try {

            em.persist(actorType);
            return OK();
        } catch (Exception e) {
            e.printStackTrace();
            return BAD(e.getMessage());
        }
    }

    @Override
    public EmgResponseStatus setPrincipalRole(EmgUserRole role) {
        try {
            em.persist(role);
            return OK();
        } catch (Exception e) {
            e.printStackTrace();
            return BAD(e.getMessage());

        }
    }

    @Override
    public EmgUser findUserById(String s) {
        try {
            Query q = em.createQuery("select e from EmgUserImpl e where e.userName IN:s")
                    .setParameter("s",s);
            return (EmgUser) q.getResultList().get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        }
    }

    @Override
    public List<EmgUser> findUsers() {

        try {
            Query q = em.createQuery("select  e from  EmgUserImpl e");
            return q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    EmgResponseStatus OK() {
        res.setSuccess(true);
        res.setMessage("OK");
        return res;
    }

    EmgResponseStatus BAD(String e) {
        res.setSuccess(false);
        res.setMessage(e);
        return res;
    }
}
