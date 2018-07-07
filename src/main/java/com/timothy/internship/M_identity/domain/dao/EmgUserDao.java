package com.timothy.internship.M_identity.domain.dao;

import com.timothy.internship.M_core.EmgResponseStatus;
import com.timothy.internship.M_identity.domain.model.EmgActor;
import com.timothy.internship.M_identity.domain.model.EmgUser;
import com.timothy.internship.M_identity.domain.model.EmgUserRole;

import java.util.List;

public interface EmgUserDao {
    EmgResponseStatus createPrincipal(EmgUser user);
    EmgResponseStatus setPrincipalActor(EmgActor actorType);
    EmgResponseStatus setPrincipalRole(EmgUserRole role);
    EmgUser findUserById(String s);
    List<EmgUser> findUsers();
}
