package com.timothy.internship.M_security.controller.vo;

public class AuthoritiesVo {
    public AuthoritiesVo() {
    }

    private long authId;
private String authName;

    public AuthoritiesVo(long authId, String authName) {
        this.authId = authId;
        this.authName = authName;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public long getAuthId() {
        return authId;
    }

    public void setAuthId(long authId) {
        this.authId = authId;
    }
}
