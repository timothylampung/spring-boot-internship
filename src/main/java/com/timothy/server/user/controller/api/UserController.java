package com.timothy.server.user.controller.api;


import com.timothy.server.user.controller.transformer.PrincipalTransformer;
import com.timothy.server.user.controller.vo.UserVo;
import com.timothy.server.user.domain.model.EmgUser;
import com.timothy.server.user.service.EmgUserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    EmgUserService userService;
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @GetMapping("/all")
    public List<EmgUser> findAllUsers() {
        return userService.findAllUser();
    }


    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public ResponseEntity<EmgUser> findUserByUsername(@PathVariable String username) {
        EmgUser user = userService.findUserByUsername(username);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public EmgUser updateUser(@RequestBody UserVo user) {
        return userService.saveUser(user);
    }


}
