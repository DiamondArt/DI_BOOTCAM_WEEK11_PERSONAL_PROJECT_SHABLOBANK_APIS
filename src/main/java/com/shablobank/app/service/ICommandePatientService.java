package com.shablobank.app.service;

import com.shablobank.app.models.CommandePatient;

import java.util.Optional;

public interface ICommandePatientService {
    public CommandePatient saveCommande(CommandePatient commandePatient);
    public Optional<CommandePatient> findById(Long commandeId);
}
