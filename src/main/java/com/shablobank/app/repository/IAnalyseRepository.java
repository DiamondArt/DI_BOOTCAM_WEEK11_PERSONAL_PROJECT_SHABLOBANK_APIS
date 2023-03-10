package com.shablobank.app.repository;

import com.shablobank.app.models.Analyse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAnalyseRepository extends JpaRepository<Analyse, Long> {

}
