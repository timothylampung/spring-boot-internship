package com.timothy.internship.M_security.domain.model;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class EmgCustomIntUserDetails extends EmgUserImpl implements UserDetails {

    private EmgUser thisIntUser;

    public EmgCustomIntUserDetails(final EmgUserImpl user) {
        super(user);
        thisIntUser = user;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Set<EmgRoleImpl> roles = thisIntUser.getRoles();

        return roles.stream().map(role -> new SimpleGrantedAuthority( "ROLE_"+role.getAccessLevelRole())).collect(Collectors.toList());

    }

    @Override
    public String getPassword() {
        return thisIntUser.getUserPassword();
    }

    @Override
    public String getUsername() {
        return thisIntUser.getUsername() ;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
