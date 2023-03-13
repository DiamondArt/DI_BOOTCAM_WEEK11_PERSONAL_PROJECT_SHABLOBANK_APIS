package com.shablobank.app.repository;

import com.shablobank.app.models.Bloods;
import com.shablobank.app.models.Hopital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBloodRepository extends JpaRepository<Bloods, Long> {

    @Query(value = "SELECT * FROM tbloods WHERE id_hopital=:idHopital", nativeQuery = true)
    List<Bloods> findAllByHopital(Long idHopital);

    @Query(value = "SELECT * FROM tbloods WHERE id_hopital=:idHopital AND blood_type=:bloodType", nativeQuery = true)
    List<Bloods> findAllByHopitalAndBloodTypeIgnoreCase(Long idHopital, String bloodType);
    List<Bloods> findAllByBloodTypeIgnoreCase(String bloodType);

}
