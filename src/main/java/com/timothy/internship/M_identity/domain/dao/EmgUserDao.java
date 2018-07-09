package com.timothy.internship.M_identity.domain.dao;

import com.timothy.internship.M_core.EmgResponseStatus;
import com.timothy.internship.M_identity.domain.model.*;

import java.util.List;
import java.util.Set;

public interface EmgUserDao {
    EmgResponseStatus createActor(EmgUser actor);
    EmgResponseStatus setActorRole(EmgUser actor, Set<EmgRoleImpl> role);
    EmgResponseStatus updateActor(EmgUser actor);

    EmgResponseStatus createIdentity (EmgIdentity identity);
    EmgResponseStatus setIdentityActor(EmgUser actor, EmgIdentity identity);
    EmgResponseStatus updateIdentity(EmgIdentity identity);

    EmgIdentity getIdentityByActorId(long actorId);

    EmgUser findActorById(long s);
    EmgUser findActorByUsername (String username);
    List<EmgUser> findUsers();
}
