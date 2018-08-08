package com.timothy.server.user.domain.model;


import com.timothy.server.core.domain.model.DateAuditImpl;

import javax.persistence.*;

@Entity
@Table(name="dt_user_role")
public class EmgUserRoleImpl extends DateAuditImpl implements EmgUserRole {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="dt_user_role_id")
    private long userRoleId;

    @Column(name="dt_user_id")
    private long userId;

    @Column(name = "dt_accesslevel_id")
    private long accessLevelId;

    @Override
    public void setUserId(long userId) {
        this.userId =userId;
    }

    @Override
    public void setAccessLevelId(long accessLevelId) {
    this.accessLevelId =accessLevelId;
    }


    public EmgUserRoleImpl() {

    }

    public long getId() {
        return userRoleId;
    }

    public void setId(long id) {
        this.userRoleId = id;
    }

}
