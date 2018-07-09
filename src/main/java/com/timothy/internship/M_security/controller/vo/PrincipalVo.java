package com.timothy.internship.M_security.controller.vo;

import java.util.Set;

public class PrincipalVo {

    private String username;
    private String email;
    private String contact;
    private Set<AuthoritiesVo> authorities;

    public PrincipalVo() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Set<AuthoritiesVo> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<AuthoritiesVo> authorities) {
        this.authorities = authorities;
    }

    public PrincipalVo(String username, String email, String contact, Set<AuthoritiesVo> authorities) {
        this.username = username;
        this.email = email;
        this.contact = contact;
        this.authorities = authorities;
    }
}
