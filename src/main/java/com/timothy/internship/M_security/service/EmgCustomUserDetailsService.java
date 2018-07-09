package com.timothy.internship.M_security.service;



import com.timothy.internship.M_security.domain.dao.EmgUserRepository;
import com.timothy.internship.M_security.domain.model.EmgCustomIntUserDetails;
import com.timothy.internship.M_security.domain.model.EmgUserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmgCustomUserDetailsService implements UserDetailsService {

    private final EmgUserRepository emgUserRepository;

    @Autowired
    public EmgCustomUserDetailsService(EmgUserRepository emgUserRepository) {
        this.emgUserRepository = emgUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<EmgUserImpl> optionalUser = emgUserRepository.findByUserName(username);

        optionalUser.orElseThrow(()-> new UsernameNotFoundException("Username Not Found"));

        return optionalUser.map(
                EmgCustomIntUserDetails::new
        ).get();

    }
}
