package com.shablobank.app.service;

import com.shablobank.app.controller.exception.EntityException;
import com.shablobank.app.models.Demandes;
import java.util.List;

public interface IDemandeService {
    public Demandes saveDemande(Demandes demandes);
    List<Demandes> fetchDemandesList();

    Demandes acceptDemandes(Long idDemande,Demandes demandes) throws EntityException;

}
