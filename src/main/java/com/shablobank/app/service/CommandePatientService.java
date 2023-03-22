package com.shablobank.app.service;

import com.shablobank.app.models.CommandePatient;
import com.shablobank.app.repository.ICommandePatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommandePatientService implements ICommandePatientService {

    @Autowired
    ICommandePatientRepository commandePatientRepository;
    @Override
    public CommandePatient saveCommande(CommandePatient commandePatient) {
        return commandePatientRepository.save(commandePatient);
    }

    @Override
    public Optional<CommandePatient> findById(Long commandeId) {
        return commandePatientRepository.findById(commandeId);
    }
}
