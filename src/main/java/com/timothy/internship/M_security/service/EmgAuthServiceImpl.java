package com.timothy.internship.M_security.service;


import com.timothy.internship.M_identity.domain.dao.EmgUserDao;
import com.timothy.internship.M_identity.domain.model.EmgUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
public class EmgAuthServiceImpl implements EmgAuthService {

    private final
    EmgUserDao emgUserDao;

    @Autowired
    public EmgAuthServiceImpl(EmgUserDao emgUserDao) {
        this.emgUserDao = emgUserDao;
    }





    @Override
    public EmgUser getCurrentLogged() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return emgUserDao.findActorByUsername(auth.getName());
    }
}
