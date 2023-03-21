package com.shablobank.app.repository;


import com.shablobank.app.models.Demandes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDemandeRepository extends JpaRepository<Demandes,Long> {
}
