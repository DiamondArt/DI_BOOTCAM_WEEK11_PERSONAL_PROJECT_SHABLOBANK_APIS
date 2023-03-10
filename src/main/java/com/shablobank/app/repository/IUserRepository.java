package com.shablobank.app.repository;

import com.shablobank.app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface IUserRepository extends JpaRepository<User, Long> {

}
