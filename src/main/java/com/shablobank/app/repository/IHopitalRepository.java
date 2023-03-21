package com.shablobank.app.repository;

import com.shablobank.app.models.Hopital;
import com.shablobank.app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface IHopitalRepository  extends JpaRepository<Hopital, Long> {

    @Query(value = "SELECT * FROM thopitals WHERE id=:hopitalId", nativeQuery = true)
    //@Query(value = "SELECT user_id FROM user_event ue " +
            //"WHERE ue.user_id = :userId", nativeQuery = true)
    Hopital findHopitalQueryMethod(@Param("hopitalId") Long hopitalId);

    @Query(value = "SELECT name FROM thopitals WHERE id=:hopitalId", nativeQuery = true)
    public String findByName(Long hopitalId);
    public Hopital findByNameIgnoreCase(String hopitalName);
}
