package com.timothy.server.user.domain.model;

import javax.persistence.*;

@Entity
@Table(name="dt_role")
public class EmgRoleImpl implements EmgRole {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "dt_role_id")
  private long roleId;

  @Column(name="dt_role_desc")
  private String AccessLevelRole;



  public EmgRoleImpl() {
  }

  public EmgRoleImpl(long roleId, String AccessLevelRole) {
    this.AccessLevelRole = AccessLevelRole;
    this.roleId = roleId;
  }



  public long getAccessLevelId() {
    return roleId;
  }

  public void setAccessLevelId(long roleId) {
    this.roleId = roleId;
  }


  public String getAccessLevelRole() {
    return AccessLevelRole;
  }

  public void setAccessLevelRole(String dtAccessLevelRole) {
    this.AccessLevelRole = dtAccessLevelRole;
  }

}
