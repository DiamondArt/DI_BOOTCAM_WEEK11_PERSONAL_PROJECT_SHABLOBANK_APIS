package com.shablobank.app.controllers;

import com.shablobank.app.Exception.EntityException;
import com.shablobank.app.models.Analyse;
import com.shablobank.app.models.Bloods;
import com.shablobank.app.models.Hopital;
import com.shablobank.app.repository.IAnalyseRepository;
import com.shablobank.app.repository.IBloodRepository;
import com.shablobank.app.service.AnalyseService;
import com.shablobank.app.service.BloodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/blood")
@CrossOrigin("*")
public class BloodController {
    @Autowired
    private IBloodRepository bloodRepository;
    @Autowired
    private BloodService bloodService;
    private final Logger LOGGER = LoggerFactory.getLogger(com.shablobank.app.controllers.AnalyseController.class);

    @GetMapping()
    public ResponseEntity<List<Object>> fetchAllBlood() {

        List<Bloods> entityList = bloodService.fetchAllBloodsList();
       /** "createdAt": "2023-03-13T11:01:23.276+00:00",
                "id": 1,
                "codeRef": "ANNN",
                "bloodType": "AB",
                "designation": "lorem ipsum",
                "quantity": "50",
                "volume": "450",
                "priceHt": null,
                "hopital": {
            "createdAt": "2023-03-13T11:00:51.068+00:00",
                    "id": 2,
                    "name": "Institut Bon pasteur",
                    "adresse": {
                "adresse1": "CHU Cocody - 01 BP 490 Abidjan 01",
                        "adresse2": "Chu d'angre",
                        "ville": "Abidjan",
                        "codePostale": "01 BP 490 Abidjan",
                        "pays": "Côte d'ivoire"
            },
            "latitude": "-3.9957911767199974",
                    "longitude": "5.345090297280184",
                    "statut_juridique": "SARL",
                    "nbre_associe": 4
        },
        "mvtStks": [],
        "bloodAnalysies": [] **/
        List<Object> entities = new ArrayList<Object>();

       //List<Object> E = new ArrayList<Object>();
        for (Bloods blood : entityList) {
            entities.add(Map.of(
                    "id", blood.getId(),
                    "codeRef", blood.getCodeRef(),
                    "bloodType", blood.getBloodType(),
                    "designation", blood.getDesignation(),
                    "quantity", blood.getQuantity(),
                    "volume", blood.getVolume(),
                    "hopital_id", blood.getHopital().getId()
            ));
        }
        return ResponseEntity.status(HttpStatus.OK).body(entities);
    }

    @GetMapping("{id}")
    public Bloods fetchBloodById(@PathVariable("id") Long idBlood) throws EntityException {

        LOGGER.info("Inside fetchBloodById BloodController ");
        return bloodService.fetchBloods(idBlood);
    }

    @GetMapping("hopital/{id}")
    public List<Bloods> queryfetchBloodByHopital(@PathVariable("id") Long idHopital) throws EntityException {

        LOGGER.info("Inside QueryfetchBloodByHopital BloodController ");
        return bloodService.findAllByHopital(idHopital);
    }

    @GetMapping("hopital/{id}/groupe/{bloodtype}")
    public List<Bloods> queryfetchBloodByHopitalAndType(@PathVariable("id") Long idHopital, @PathVariable("bloodtype") String bloodtype) throws EntityException {

        LOGGER.info("Inside queryfetchBloodByHopitalAndType BloodController ");
        return bloodService.findAllByHopitalAndBloodTypeIgnoreCase(idHopital, bloodtype);
    }

    @GetMapping("groupe/{bloodtype}")
    public List<Bloods> findAllByBloodTypeIgnoreCase(@PathVariable("bloodtype") String bloodtype){

        LOGGER.info("Inside findAllByBloodTypeIgnoreCase BloodController ");
        return bloodService.findAllByBloodTypeIgnoreCase(bloodtype);
    }

    @DeleteMapping("{id}")
    public String deleteBlood(@PathVariable("id") Long idBlood) throws EntityException{
        LOGGER.info("Inside deleteBlood BloodController ");
        bloodService.deleteBloods(idBlood);
        return "Delete successfull";
    }

    @PostMapping()
    public Bloods saveBlood(@Validated @RequestBody Bloods bloods) {
        LOGGER.info("Inside saveBlood BloodController ");
        return bloodService.saveBloods(bloods);
    }
}
