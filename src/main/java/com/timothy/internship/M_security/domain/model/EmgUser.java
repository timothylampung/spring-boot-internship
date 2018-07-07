package com.timothy.internship.M_security.domain.model;

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


    boolean getUserEnabled();
    void setUserEnabled(boolean enabled);

     Set<EmgRoleImpl> getRoles();

     void setRoles(Set<EmgRoleImpl> roles);
}
