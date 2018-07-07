package com.timothy.internship.M_identity.domain.model;


import javax.persistence.*;

@Entity
@Table(name="dt_user_role")
public class EmgUserRoleImpl implements EmgUserRole {



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
