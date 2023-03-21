package com.shablobank.app.service;

import com.shablobank.app.controller.exception.EntityException;
import com.shablobank.app.models.Hopital;
import com.shablobank.app.repository.IHopitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class HopitalService implements IHopitalService{
    @Autowired
    private IHopitalRepository hopitalRepository;
    @Override
    public Hopital saveHopital(Hopital hopital) {

        return hopitalRepository.save(hopital);
    }

    @Override
    public List<Hopital> fetchHopitalList() {
        return hopitalRepository.findAll();
    }

    @Override
    public Hopital fetchHopital(Long idHopital) throws EntityException {

        Optional<Hopital> hopital = hopitalRepository.findById(idHopital);
        if (!hopital.isPresent()) {
            throw new EntityException("Hopital not found");
        }
        return hopital.get();
    }

    @Override
    public void deleteHopital(Long idHopital) throws EntityException {
        Optional<Hopital> hopital = hopitalRepository.findById(idHopital);
        if (!hopital.isPresent()) {
            throw new EntityException("Hopital not available ");
        }
        hopitalRepository.deleteById(idHopital);
    }

    @Override
    public Hopital updateHopital(Long idHopital, Hopital hopital) throws EntityException {
        Optional<Hopital> findhopital = hopitalRepository.findById(idHopital);
        if (!findhopital.isPresent()) {
            throw new EntityException("No value present");
        }

        Hopital hopitalDb = hopitalRepository.findById(idHopital).get();
        if(Objects.nonNull(hopital.getName()) &&!"".equalsIgnoreCase(hopital.getName())){
            hopitalDb.setName(hopital.getName());
        }

        if(Objects.nonNull(hopital.getLongitude()) &&!"".equalsIgnoreCase(hopital.getLongitude())){
            hopitalDb.setLongitude(hopital.getLongitude());
        }
        if(Objects.nonNull(hopital.getLatitude()) &&!"".equalsIgnoreCase(hopital.getLatitude())){
            hopitalDb.setLatitude(hopital.getLatitude());
        }
        if(Objects.nonNull(hopital.getAdresse())){
            hopitalDb.setAdresse(hopital.getAdresse());
        }

        return hopitalRepository.save(hopitalDb);
    }

    @Override
    public Hopital fetchHopitalByName(String hopitalName){
        return hopitalRepository.findByNameIgnoreCase(hopitalName);

    }

    @Override
    public Hopital QueryfetchHopitalById(Long idHopital){

        return hopitalRepository.findHopitalQueryMethod(idHopital);
    }

    @Override
    public String getHopitalName(Long id) {
        return hopitalRepository.findByName(id);
    }
}
