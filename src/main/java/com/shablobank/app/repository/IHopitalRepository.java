package com.shablobank.app.repository;

import com.shablobank.app.models.Hopital;
import com.shablobank.app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IHopitalRepository  extends JpaRepository<Hopital, Long> {

    @Query(value = "SELECT * FROM thopitals WHERE id=:hopitalId", nativeQuery = true)
    Hopital findHopitalQueryMethod(@Param("hopitalId") Long hopitalId);

    @Query(value = "SELECT name FROM thopitals WHERE id=:hopitalId", nativeQuery = true)
    public String findByName(Long hopitalId);

    @Query(value = "SELECT SUM(CAST(tbloods.quantity AS INT)) as quantity,tbloods.blood_type, thopitals.name, thopitals.latitude,thopitals.longitude FROM tbloods WHERE tbloods.id_hopital=thopitals.id  GROUP BY tbloods.blood_type", nativeQuery = true)
    public List<Object> mapStats();
    public Hopital findByNameIgnoreCase(String hopitalName);
}
