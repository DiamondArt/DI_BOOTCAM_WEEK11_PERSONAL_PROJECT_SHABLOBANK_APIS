package com.shablobank.app.controller;

import com.shablobank.app.controller.exception.EntityException;
import com.shablobank.app.models.Bloods;
import com.shablobank.app.repository.IBloodRepository;
import com.shablobank.app.service.BloodService;
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
@RequestMapping("/api/blood")
@CrossOrigin("*")
public class BloodController {
    @Autowired
    private IBloodRepository bloodRepository;
    @Autowired
    private BloodService bloodService;
    private final Logger LOGGER = LoggerFactory.getLogger(com.shablobank.app.controller.AnalyseController.class);

    @GetMapping()
    public ResponseEntity<List<Object>> fetchAllBlood() {

        List<Bloods> entityList = bloodService.fetchAllBloodsList();
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
                    "hopital_id", blood.getHopital().getId(),
                    "createdAt", blood.getCreatedAt()
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
    public ResponseEntity<Object> deleteBlood(@PathVariable("id") Long idBlood) throws EntityException{
        LOGGER.info("Inside deleteBlood BloodController ");
        bloodService.deleteBloods(idBlood);
        String message ="Delete successfull";
        return ResponseEntity.status(HttpStatus.OK).body(
                Map.of("message", message));
    }

    @PostMapping()
    public Bloods saveBlood(@Validated @RequestBody Bloods bloods) {
        LOGGER.info("Inside saveBlood BloodController ");
        return bloodService.saveBloods(bloods);
    }
}
