package com.example.apirestpostgreconcecionaria.repository;

import com.example.apirestpostgreconcecionaria.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> finByUsername(String username);

    Boolean existByUsername(String usename);

    Boolean existByEmail(String email);

}
