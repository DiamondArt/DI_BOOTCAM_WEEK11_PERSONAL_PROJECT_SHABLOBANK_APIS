package com.shablobank.app.repository;

import com.shablobank.app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public interface IUserRepository extends JpaRepository<User, Long> {

    @Query("SELECT c FROM User c WHERE c.email = ?1 ")
    User findUserByEmail(String email);
    Optional<User> findByFirstnameOrEmail(String firstname, String email);

    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);
}
