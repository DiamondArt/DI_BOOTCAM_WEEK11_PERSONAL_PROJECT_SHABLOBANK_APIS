package com.shablobank.app.service;

import com.shablobank.app.controller.exception.EntityException;
import com.shablobank.app.models.Demandes;
import com.shablobank.app.repository.IBloodRepository;
import com.shablobank.app.repository.IDemandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemandeService implements  IDemandeService {

    @Autowired
    private IDemandeRepository demandeRepository;
    @Override
    public Demandes saveDemande(Demandes demandes) {
        return demandeRepository.save(demandes);
    }

    @Override
    public List<Demandes> fetchDemandesList() {
        return demandeRepository.findAll();
    }

    @Override
    public Demandes acceptDemandes(Long idDemande,Demandes demandes) throws EntityException {
        Optional<Demandes> demande = demandeRepository.findById(idDemande);
        if (demande.isPresent()) {
            Demandes _demande = demande.get();
            _demande.setIdHopitalTraitant(demandes.getIdHopitalTraitant());
            _demande.setStatut(true);
            return demandeRepository.save(_demande);
        } else {
            throw new EntityException("Item not available ");
        }
    }
}
