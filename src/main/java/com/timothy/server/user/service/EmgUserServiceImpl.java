package com.timothy.server.user.service;

import com.timothy.server.user.controller.vo.RoleVo;
import com.timothy.server.user.controller.vo.UserVo;
import com.timothy.server.user.domain.dao.EmgUserDao;
import com.timothy.server.user.domain.model.EmgUser;
import com.timothy.server.user.domain.model.EmgUserImpl;
import io.jsonwebtoken.JwtBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmgUserServiceImpl implements EmgUserService {


    @Autowired
    private EmgUserDao emgUserDao;
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    public EmgUserServiceImpl() {
    }





    @Override
    public EmgUser findUserByUsername(String username) {
        try {
            return emgUserDao.findByUserName(username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public EmgUser saveUser(UserVo vo) {

        try {




            EmgUser user = new EmgUserImpl();
            user.setUserPassword( passwordEncoder.encode(vo.getPassword()) );
            user.setUserActiveStatus(true);
            user.setUserEnabled(true);
            user.setUserContact(vo.getContact());
            user.setUserEmail(vo.getEmail());
            user.setUsername(vo.getUsername());
            EmgUser res = emgUserDao.save(user);

            EmgUser u=emgUserDao.findByUserName(res.getUsername());

            for(RoleVo role : vo.getAuthorities()){
                emgUserDao.setUserRole(u.getUserId(),role.getAuthId());
            }

            return u;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<EmgUser> findAllUser() {
        try {
            return emgUserDao.findAll() ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public EmgUser getSignedInUser() {
        return null;
    }


}
