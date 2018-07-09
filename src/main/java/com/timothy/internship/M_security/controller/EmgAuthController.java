package com.timothy.internship.M_security.controller;


import com.timothy.internship.M_identity.domain.model.EmgUser;
import com.timothy.internship.M_security.controller.transformer.PrincipalTransformer;
import com.timothy.internship.M_security.controller.vo.PrincipalVo;
import com.timothy.internship.M_security.service.EmgAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Map;

@RequestMapping("/internship")
@Controller
public class EmgAuthController {

    private static String TITLE = "Internship App";

    private PrincipalTransformer transformer = new PrincipalTransformer();

    private final EmgAuthService emgAuthService;

    @Autowired
    public EmgAuthController(EmgAuthService emgAuthService) {
        this.emgAuthService = emgAuthService;
    }


    @RequestMapping("/login")
    public String welcome(Map<String, Object> model) {
        model.put("message", "HELLO");
        model.put("title",TITLE);

        return "login-page";
    }

    @PreAuthorize("hasAnyRole({'ADMIN','STUDENT','LECTURER'})")
    @RequestMapping("/home")
    public String home(Map<String, Object> model) {
        EmgUser user = emgAuthService.getCurrentLogged();
        PrincipalVo vo = transformer.toVo(user);
        ArrayList<String> item = new ArrayList<>();

        for(int  i = 0 ; i<5 ; i++){
            item.add("Day "+(i+1));
        }

        model.put("title",TITLE);
        model.put("profile", vo);
        model.put("item", item);
        return "home-page";
    }


    @PreAuthorize("hasAnyRole({'ADMIN','STUDENT','LECTURER'})")
    @RequestMapping("/profile")
    public String profile(Map<String, Object> model) {
        EmgUser user = emgAuthService.getCurrentLogged();
        PrincipalVo vo = transformer.toVo(user);
        model.put("title",TITLE);
        model.put("profile",vo);

        return "profile-page";
    }


    @PreAuthorize("hasAnyRole({'ADMIN','STUDENT','LECTURER'})")
    @RequestMapping("/companies/{id}")
    public String companies(Map<String, Object> model, @PathVariable String id) {
        EmgUser user = emgAuthService.getCurrentLogged();
        PrincipalVo vo = transformer.toVo(user);


        model.put("title",TITLE);
        model.put("profile",vo);
        return "companies-page";
    }


    @PreAuthorize("hasAnyRole({'ADMIN','STUDENT','LECTURER'})")
    @RequestMapping("/progress")
    public String progress(Map<String, Object> model) {
        EmgUser user = emgAuthService.getCurrentLogged();
        PrincipalVo vo = transformer.toVo(user);

        model.put("title",TITLE);
        model.put("profile",vo);
        return "progress-page";
    }


}
