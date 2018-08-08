package com.timothy.server.security.controller;

import com.timothy.server.user.controller.vo.UserVo;
import com.timothy.server.user.domain.model.EmgUser;
import com.timothy.server.user.service.EmgUserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/security")
public class SecurityController {

    @Autowired
    EmgUserService userService;
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @RequestMapping(value = "user/login", method = RequestMethod.POST)
    public String login(@RequestBody SecurityVo input) throws
            ServletException {

        if (input.getUsername() == null || input.getPassword() == null) {
            throw new ServletException("Please fill in username and password");
        }



        EmgUser user = userService.findUserByUsername(input.getUsername());
        if (user == null) {
            throw new ServletException("User name not found.");
        }

        String pwd = user.getUserPassword();

        if (!passwordEncoder.matches(input.getPassword(), pwd)) {
            throw new ServletException("Invalid login. Please check your username and password");
        }


        return Jwts.builder().setSubject(input.getUsername()).claim("roles", "user").setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();
    }

    @RequestMapping(value = "user/register", method = RequestMethod.POST)
    public ResponseEntity<String> registerUser(@RequestBody UserVo user) {
        userService.saveUser(user);
        return new ResponseEntity<String>(user.getUsername() + " Created", HttpStatus.OK);
    }

}
