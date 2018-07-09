package com.timothy.internship.M_security.controller.transformer;

import com.timothy.internship.M_identity.domain.model.EmgRole;
import com.timothy.internship.M_identity.domain.model.EmgUser;
import com.timothy.internship.M_identity.domain.model.EmgUserImpl;
import com.timothy.internship.M_security.controller.vo.AuthoritiesVo;
import com.timothy.internship.M_security.controller.vo.PrincipalVo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrincipalTransformer {


    public PrincipalTransformer() {
    }

     public PrincipalVo toVo(EmgUser user) {
         PrincipalVo vo = new PrincipalVo();
         Set<AuthoritiesVo> authVos= new HashSet<AuthoritiesVo>();

         vo.setUsername(user.getUsername());
         vo.setContact(user.getUserContact());
         vo.setEmail(user.getUserEmail());

         for (EmgRole role :user.getRoles()){
             AuthoritiesVo authoritiesVo = new AuthoritiesVo(role.getAccessLevelId(),role.getAccessLevelRole());
             authVos.add(authoritiesVo);
         }

         vo.setAuthorities(authVos);

         return vo;
     }



     public List<PrincipalVo> toVos (List<EmgUser> users){
        List<PrincipalVo> vos = new ArrayList<>();
        for(EmgUser user :users){
            PrincipalVo vo = new PrincipalVo();
            Set<AuthoritiesVo> authVos= new HashSet<AuthoritiesVo>();

            vo.setUsername(user.getUsername());
            vo.setContact(user.getUserContact());
            vo.setEmail(user.getUserEmail());

            for (EmgRole role :user.getRoles()){
                AuthoritiesVo authoritiesVo = new AuthoritiesVo(role.getAccessLevelId(),role.getAccessLevelRole());
                authVos.add(authoritiesVo);
            }

            vo.setAuthorities(authVos);




        }
      return vos;
     }


}
