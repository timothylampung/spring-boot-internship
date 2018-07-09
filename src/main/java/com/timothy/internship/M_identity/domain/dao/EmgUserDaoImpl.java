package com.timothy.internship.M_identity.domain.dao;

import com.timothy.internship.M_core.EmgResponseStatus;
import com.timothy.internship.M_identity.domain.model.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Repository
@Transactional
public class EmgUserDaoImpl implements EmgUserDao {

    @PersistenceContext
    private EntityManager em;

    private EmgResponseStatus res = new EmgResponseStatus();

    public EmgUserDaoImpl() {

    }


    @Override
    public EmgResponseStatus createActor(EmgUser user) {
        try {

            em.persist(user);
            return OK();
        } catch (Exception e) {
            e.printStackTrace();
            return BAD(e.getMessage());
        }
    }


    @Override
    public EmgResponseStatus setActorRole(EmgUser actor, Set<EmgRoleImpl> roles) {
        try {
            em.persist(roles);
            actor.setRoles(roles);
            return OK();
        } catch (Exception e) {
            e.printStackTrace();
            return BAD(e.getMessage());

        }
    }

    @Override
    public EmgResponseStatus updateActor(EmgUser actor) {
        return OK(); //TODO update the actor
    }

    @Override
    public EmgResponseStatus createIdentity(EmgIdentity identity) {
        return null;
    }

    @Override
    public EmgResponseStatus setIdentityActor(EmgUser actor, EmgIdentity identity) {
        try {
            identity.setActor(actor);
            return OK();
        } catch (Exception e) {
            e.printStackTrace();
            return BAD(e.getMessage());
        }
    }

    @Override
    public EmgResponseStatus updateIdentity(EmgIdentity identity) {
        return OK(); //TODO update the identity
    }

    @Override
    public EmgIdentity getIdentityByActorId(long actorId) {
        return null;
    }

    @Override
    public EmgUser findActorById(long s) {
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
    public EmgUser findActorByUsername(String username) {
        try {
            Query q = em.createQuery("select e from EmgUserImpl e where e.userName IN:username")
                    .setParameter("username",username);
            return (EmgUser) q.getResultList().get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
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
