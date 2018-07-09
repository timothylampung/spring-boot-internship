package com.timothy.internship.M_security.service;


import com.timothy.internship.M_identity.domain.model.EmgUser;

public interface EmgAuthService {
//    IntPrincipalDetails registerNewUser(PrincipalVo principalVo);
//    IntPrincipalDetails findUserByUsername(String s);
    EmgUser getCurrentLogged();
}
