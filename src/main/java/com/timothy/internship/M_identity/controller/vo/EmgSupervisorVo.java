package com.timothy.internship.M_identity.controller.vo;

public class EmgSupervisorVo {

    public EmgSupervisorVo(long userId, String supervisorName, String supervisorContact, String superVisorEmail, String superVisorCompany) {
        this.userId = userId;
        this.supervisorName = supervisorName;
        this.supervisorContact = supervisorContact;
        this.superVisorEmail = superVisorEmail;
        this.superVisorCompany = superVisorCompany;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }

    public String getSupervisorContact() {
        return supervisorContact;
    }

    public void setSupervisorContact(String supervisorContact) {
        this.supervisorContact = supervisorContact;
    }

    public String getSuperVisorEmail() {
        return superVisorEmail;
    }

    public void setSuperVisorEmail(String superVisorEmail) {
        this.superVisorEmail = superVisorEmail;
    }

    public String getSuperVisorCompany() {
        return superVisorCompany;
    }

    public void setSuperVisorCompany(String superVisorCompany) {
        this.superVisorCompany = superVisorCompany;
    }

    public EmgSupervisorVo() {
    }

    private long userId;
    private String supervisorName;
    private String supervisorContact;
    private String superVisorEmail;
    private String superVisorCompany;
}
