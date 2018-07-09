package com.timothy.internship.M_identity.controller.api;

import com.timothy.internship.M_identity.controller.vo.EmgUserVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@PreAuthorize("hasAnyRole({'ADMIN','LECTURER','STUDENT'})")
@RequestMapping(path = "/api/identity/")
@RestController
public class EmgIdentityController {


    @GetMapping(path = "/body")
    public String body(){

        return "HELLO";
    }

}
