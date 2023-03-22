package com.shablobank.app.controller;

import com.shablobank.app.controller.exception.EntityException;
import com.shablobank.app.models.Bloods;
import com.shablobank.app.models.CommandePatient;
import com.shablobank.app.service.BloodService;
import com.shablobank.app.service.CommandePatientService;
import com.shablobank.app.service.HopitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/v1/api/rest/commande")
public class CommandePatientController {

    @Autowired
    private CommandePatientService commandePatientService;
    @Autowired
    private HopitalService hopitalService;

    @Autowired
    private BloodService bloodService;
    @PostMapping()
    public ResponseEntity<Object> saveCommande(@Validated @RequestBody CommandePatient commandePatient) throws EntityException {
        //LOGGER.info("Inside saveBlood BloodController ");

        CommandePatient demande = commandePatientService.saveCommande(commandePatient);
        Bloods blood = bloodService.fetchBloods(demande.getBlood().getId());
        Object entities = Map.of(
                "id", demande.getId(),
                "distribution", "1000"+demande.getId()+"982",
                "rhesus", demande.getRhesus(),
                "nom", demande.getPatientNom(),
                "date_naissance", demande.getDateNaissance(),
                "codebarre", blood.getCodeRef(),
                "quantity", demande.getQuantity(),
                "hopital", hopitalService.getHopitalName(demande.getIdHopital().longValue()),
                "createdAt", demande.getCreatedAt(),
                "sexe",demande.getSexe()
        );
        bloodService.updateBlood(demande.getBlood().getId(), demande.getQuantity());
        return ResponseEntity.status(HttpStatus.OK).body(entities);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> findCommande(@PathVariable("id") Long id) throws EntityException {

        Optional<CommandePatient> demande = commandePatientService.findById(id);
        Bloods blood = bloodService.fetchBloods(demande.get().getBlood().getId());
        Object entities = Map.of(
                "id", demande.get().getId(),
                "distribution", "1000"+demande.get().getId()+"982",
                "rhesus", demande.get().getRhesus(),
                "nom", demande.get().getPatientNom(),
                "date_naissance", demande.get().getDateNaissance(),
                "codebarre", blood.getCodeRef(),
                "quantity", demande.get().getQuantity(),
                "hopital", hopitalService.getHopitalName(demande.get().getIdHopital().longValue()),
                "createdAt", demande.get().getCreatedAt(),
                "sexe",demande.get().getSexe()
        );
        return ResponseEntity.status(HttpStatus.OK).body(entities);
    }
}
