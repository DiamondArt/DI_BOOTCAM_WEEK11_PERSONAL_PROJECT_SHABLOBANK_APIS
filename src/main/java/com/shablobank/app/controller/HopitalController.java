package com.shablobank.app.controller;


import com.shablobank.app.controller.exception.EntityException;
import com.shablobank.app.models.Hopital;
import com.shablobank.app.repository.IHopitalRepository;
import com.shablobank.app.service.HopitalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/api/rest/hopital")
@CrossOrigin("*")
public class HopitalController {
    @Autowired
    private IHopitalRepository hopitalRepository;
    @Autowired
    private HopitalService hopitalService;
    private final Logger LOGGER = LoggerFactory.getLogger(HopitalController.class);
    @GetMapping("/hello")
    public Map<String, String> sayHello() {
        HashMap<String, String> map = new HashMap<>();
        map.put("key", hopitalService.getHopitalName(1L));
        map.put("foo", "bar");
        map.put("aa", "bb");
        return map;
    }

    @GetMapping(value = "/hello2",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getSomeParameters() {
        List hopitals = (List<Hopital>) hopitalRepository.findAll();
        Long id = 2L;
        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                "hopitals", hopitalService.QueryfetchHopitalById(id),
                "status", HttpStatus.OK,
                "message", "successfull")
        );
    }

    @GetMapping()
    public List<Hopital> fetchHopital() {
        return hopitalService.fetchHopitalList();
    }

    @GetMapping("/name/{name}")
    public Hopital fetchHopitalByName(@PathVariable("name") String hopitalName){
        return hopitalService.fetchHopitalByName(hopitalName);
    }

    @GetMapping("{id}")
    public Hopital fetchHopitalById(@PathVariable("id") Long idHopital) throws EntityException {

        LOGGER.info("Inside fetchHopitalHopital HopitalController ");
        return hopitalService.fetchHopital(idHopital);
    }

    @GetMapping("query/{id}")
    public Hopital QueryfetchHopitalById(@PathVariable("id") Long idHopital){

        LOGGER.info("Inside QueryFetchHopital HopitalController ");
        return hopitalService.QueryfetchHopitalById(idHopital);
    }

    @DeleteMapping("{id}")
    public String deleteHopital(@PathVariable("id") Long idHopital) throws EntityException{
        LOGGER.info("Inside delteHopital HopitalController ");

        hopitalService.deleteHopital(idHopital);
        return "Delete successfull";
    }

    @PostMapping()
    public Hopital saveHopital(@Validated @RequestBody Hopital hopital) {
        LOGGER.info("Inside SaveHopital HopitalController ");
        return hopitalService.saveHopital(hopital);
    }

    @PutMapping("{id}")
    public Hopital updateHopital(@PathVariable("id") Long idHopital, @Valid @RequestBody Hopital hopital) throws EntityException{
        LOGGER.info("Inside updateHopital HopitalController ");
        return  hopitalService.updateHopital(idHopital, hopital);
    }
}
