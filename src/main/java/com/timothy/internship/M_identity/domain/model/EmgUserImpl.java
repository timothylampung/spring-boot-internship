package com.timothy.internship.M_identity.domain.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "dt_user")
public class EmgUserImpl implements EmgUser, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dt_user_id")
    private long userId;

    @Column(name = "dt_user_name", unique = true)
    private String userName;
    @Column(name = "dt_user_contact")
    private String userContact;
    @Column(name = "dt_user_email")
    private String userEmail;
    //  @Column(name= "dt_user_access_level_id")
//  private long dtUserAccessLevel;
    @Column(name = "dt_user_password")
    private String userPassword;
    @Column(name = "dt_user_active_status")
    private boolean userActiveStatus;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "dt_user_role", joinColumns = @JoinColumn(name = "dt_user_id"), inverseJoinColumns = @JoinColumn(name = "dt_accesslevel_id"))
    private Set<EmgRoleImpl> roles;


//    @OneToOne(mappedBy = "actor", cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY, optional = false)
//    private EmgIdentityStudentImpl student;
//
//
//    @OneToOne(mappedBy = "actor", cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY, optional = false)
//    private EmgIdentityLecturerImpl lecturer;




    public EmgUserImpl() {
    }


    EmgUserImpl(EmgUserImpl user) {
        user.userActiveStatus = user.getUserActiveStatus();
        user.userContact = user.getUserContact();
        user.userEmail = user.getUserEmail();
        user.userId = user.getUserId();
        user.userName = user.getUsername();
        user.userPassword = user.getUserPassword();
        user.roles = user.getRoles();
    }


    public EmgUserImpl(String userName, String dtUserContact, String userEmail, String userPassword, boolean userActiveStatus, Set<EmgRoleImpl> roles) {
        this.userName = userName;
        this.userContact = dtUserContact;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userActiveStatus = userActiveStatus;
        this.roles = roles;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long dtUserId) {
        this.userId = dtUserId;
    }


    public String getUsername() {
        return userName;
    }

    public void setUsername(String dtUserName) {
        this.userName = dtUserName;
    }


    public String getUserContact() {
        return userContact;
    }

    public void setUserContact(String dtUserContact) {
        this.userContact = dtUserContact;
    }


    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String dtUserEmail) {
        this.userEmail = dtUserEmail;
    }


//  public long getDtUserAccessLevel() {
//    return dtUserAccessLevel;
//  }
//
//  public void setDtUserAccessLevel(long dtUserAccessLevel) {
//    this.dtUserAccessLevel = dtUserAccessLevel;
//  }


    public String getUserPassword() {
        return this.userPassword;
    }

    public void setUserPassword(String dtUserPassword) {
        this.userPassword = dtUserPassword;
    }


    public boolean getUserActiveStatus() {
        return userActiveStatus;
    }

    public void setUserActiveStatus(boolean dtUserActiveStatus) {
        this.userActiveStatus = dtUserActiveStatus;
    }

    public Set<EmgRoleImpl> getRoles() {
        return roles;
    }

    public void setRoles(Set<EmgRoleImpl> roles) {
        this.roles = roles;
    }
//
//    public EmgIdentityStudentImpl getstudent() { return student; }
//
//    public void setstudent(EmgIdentityStudentImpl student) { this.student = student; }

}
