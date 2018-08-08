package com.timothy.server.user.service;

import com.timothy.server.user.controller.vo.UserVo;
import com.timothy.server.user.domain.model.EmgUser;

import java.util.List;

public interface EmgUserService {

    EmgUser findUserByUsername(String username);

    EmgUser saveUser(UserVo user);

    List<EmgUser> findAllUser();

    EmgUser getSignedInUser ();

}
