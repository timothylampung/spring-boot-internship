package com.timothy.server.user.domain.dao;

import com.timothy.server.user.domain.model.EmgUserImpl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmgUserRepository  extends JpaRepository<EmgUserImpl,Integer> {
    Optional<EmgUserImpl> findByUserName(String userName);
}
