package com.shablobank.app.service;

import com.shablobank.app.Exception.EntityException;
import com.shablobank.app.models.Hopital;

import java.util.List;

public interface IHopitalService {
    public Hopital saveHopital(Hopital hopital);

    List<Hopital> fetchHopitalList();

    Hopital fetchHopital(Long idHopital) throws EntityException;

    void deleteHopital(Long idHopital) throws EntityException;

    Hopital updateHopital(Long idHopital, Hopital hopital) throws EntityException;

    Hopital fetchHopitalByName(String hopitalName);

    Hopital QueryfetchHopitalById(Long idHopital);
}
