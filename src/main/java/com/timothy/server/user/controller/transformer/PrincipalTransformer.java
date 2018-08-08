package com.timothy.server.user.controller.transformer;

import com.timothy.server.user.domain.model.EmgRole;
import com.timothy.server.user.domain.model.EmgUser;
import com.timothy.server.user.controller.vo.RoleVo;
import com.timothy.server.user.controller.vo.UserVo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrincipalTransformer {


    public PrincipalTransformer() {
    }

     public UserVo toVo(EmgUser user) {
         UserVo vo = new UserVo();
         Set<RoleVo> authVos= new HashSet<RoleVo>();

         vo.setUsername(user.getUsername());
         vo.setContact(user.getUserContact());
         vo.setEmail(user.getUserEmail());

         if (!user.getRoles().isEmpty()) {
             for (EmgRole role :user.getRoles()){
                 RoleVo roleVo = new RoleVo(role.getAccessLevelId(),role.getAccessLevelRole());
                 authVos.add(roleVo);
             }
         }

         vo.setAuthorities(authVos);

         return vo;
     }



     public List<UserVo> toVos (List<EmgUser> users){
        List<UserVo> vos = new ArrayList<>();
        for(EmgUser user :users){
            UserVo vo = new UserVo();
            Set<RoleVo> authVos= new HashSet<RoleVo>();

            vo.setUsername(user.getUsername());
            vo.setContact(user.getUserContact());
            vo.setEmail(user.getUserEmail());

            for (EmgRole role :user.getRoles()){
                RoleVo roleVo = new RoleVo(role.getAccessLevelId(),role.getAccessLevelRole());
                authVos.add(roleVo);
            }

            vo.setAuthorities(authVos);




        }
      return vos;
     }


}
