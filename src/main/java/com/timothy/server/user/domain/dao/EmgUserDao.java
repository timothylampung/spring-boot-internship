package com.timothy.server.user.domain.dao;

import com.timothy.server.user.domain.model.EmgUser;

import java.util.List;

public interface EmgUserDao {


    List<EmgUser> findAll() throws Exception;

    EmgUser findByUserName(String userName) throws Exception;

    EmgUser findByUserId(Long userId) throws Exception;

    EmgUser save(EmgUser user) throws Exception;

    void setUserRole (long uId, long roleId) throws Exception;

}
