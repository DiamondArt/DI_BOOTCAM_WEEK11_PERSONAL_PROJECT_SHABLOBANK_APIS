package com.shablobank.app.controller;

import com.shablobank.app.controller.exception.EntityException;
import com.shablobank.app.models.Bloods;
import com.shablobank.app.models.Demandes;
import com.shablobank.app.service.DemandeService;
import com.shablobank.app.service.HopitalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/api/rest/demande")
@CrossOrigin("*")
public class CommandeController {
    @Autowired
    private DemandeService demandeService;

    @Autowired
    private HopitalService hopitalService;
    private final Logger LOGGER = LoggerFactory.getLogger(com.shablobank.app.controller.AnalyseController.class);

    @GetMapping()
    public ResponseEntity<List<Object>> fetchAllDemandes() {

        List<Demandes> entityList = demandeService.fetchDemandesList();
        List<Object> entities = new ArrayList<Object>();

        for (Demandes demande : entityList) {
            entities.add(Map.of(
                    "id", demande.getId(),
                    "bloodType", demande.getBloodType(),
                    "designation", demande.getInfo() == null ? "" : demande.getInfo() ,
                    "quantity", demande.getQuantity(),
                    "hopital_id", hopitalService.getHopitalName(demande.getHopital().getId()),
                    "statut", demande.getStatut(),
                    "hopital_traitant", demande.getIdHopitalTraitant() == null ? "" :  hopitalService.getHopitalName(demande.getIdHopitalTraitant().longValue()),
                    "createdAt", demande.getCreatedAt()
            ));
        }
        return ResponseEntity.status(HttpStatus.OK).body(entities);
    }

    @PostMapping()
    public ResponseEntity<Demandes> saveCommande(@Validated @RequestBody Demandes demandes) {
        LOGGER.info("Inside create a demande DemandeController ");
        Demandes demande = demandeService.saveDemande(demandes);
        return ResponseEntity.status(HttpStatus.CREATED).body(demande);
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> updateCommande(@PathVariable("id") Long id, @RequestBody Demandes demandes) throws EntityException {
        LOGGER.info("Inside update a demande DemandeController ");
        Demandes demande = demandeService.acceptDemandes(id, demandes);
        Object entities = Map.of(
                "id", demande.getId(),
                "bloodType", demande.getBloodType(),
                "statut", demande.getStatut(),
                "designation", demande.getInfo(),
                "quantity", demande.getQuantity(),
                "hopital_traitant", demande.getIdHopitalTraitant(),
                "hopital_id", demande.getHopital().getId(),
                "createdAt", demande.getCreatedAt(),
                "updatedAt",demande.getUpdatedAt()
        );
        return ResponseEntity.status(HttpStatus.OK).body(entities);
    }
}
