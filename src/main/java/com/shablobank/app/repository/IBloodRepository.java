package com.shablobank.app.repository;

import com.shablobank.app.models.Bloods;
import com.shablobank.app.models.Hopital;
import com.shablobank.app.payload.BloodDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBloodRepository extends JpaRepository<Bloods, Long> {

    @Query(value = "SELECT * FROM tbloods WHERE id_hopital=:idHopital ORDER BY id Desc", nativeQuery = true)
    List<Bloods> findAllByHopitalByOrderByIdDesc(Long idHopital);

    @Query(value = "SELECT SUM(CAST(quantity AS INT)) as quantity,blood_type FROM tbloods WHERE id_hopital=:idHopital GROUP BY blood_type", nativeQuery = true)
    List<Object>countAllByQuantityAndHopital(Long idHopital);

    @Query(value = "SELECT * FROM tbloods WHERE id_hopital=:idHopital AND blood_type=:bloodType ORDER BY id Desc ", nativeQuery = true)
    List<Bloods> findAllByHopitalAndBloodTypeIgnoreCase(Long idHopital, String bloodType);
    List<Bloods> findAllByBloodTypeIgnoreCase(String bloodType);

}
