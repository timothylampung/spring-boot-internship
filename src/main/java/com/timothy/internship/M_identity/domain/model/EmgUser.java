package com.timothy.internship.M_identity.domain.model;

import java.util.Set;

public interface EmgUser {

    long getUserId();

    void setUserId(long dtUserId);


    String getUsername();

    void setUsername(String dtUserName);


    String getUserContact();

    void setUserContact(String dtUserContact);


    String getUserEmail();

    void setUserEmail(String dtUserEmail);


    String getUserPassword();

    void setUserPassword(String dtUserPassword);


    boolean getUserActiveStatus();

    void setUserActiveStatus(boolean dtUserActiveStatus);

     Set<EmgRoleImpl> getRoles();

     void setRoles(Set<EmgRoleImpl> roles);
}
