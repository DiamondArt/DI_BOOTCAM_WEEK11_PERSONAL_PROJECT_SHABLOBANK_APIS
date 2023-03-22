package com.shablobank.app.repository;

import com.shablobank.app.models.CommandePatient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommandePatientRepository extends JpaRepository<CommandePatient, Long> {

}
