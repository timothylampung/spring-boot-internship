package com.timothy.internship.M_security.domain.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="dt_access_level")
public class EmgRoleImpl implements EmgRole, Serializable {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "dt_access_level_id")
  private long roleId;

  @Column(name="dt_access_level_role")
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
