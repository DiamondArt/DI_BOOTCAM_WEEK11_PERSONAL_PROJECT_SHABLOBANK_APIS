package com.shablobank.app.service;

import com.shablobank.app.controller.exception.EntityException;
import com.shablobank.app.models.Bloods;
import com.shablobank.app.payload.BloodDto;

import java.util.Collection;
import java.util.List;

public interface IBloodService {
    public Bloods saveBloods(Bloods bloods);

    List<Bloods> fetchAllBloodsList();

    Bloods fetchBloods(Long idBloods) throws EntityException;

    void deleteBloods(Long idBloods) throws EntityException;

    Bloods updateBloods(Long idBloods, Bloods blood) throws EntityException;

    List<Bloods> findAllByHopital(Long idHopital) throws EntityException;
    List<Bloods> findAllByHopitalAndBloodTypeIgnoreCase(Long idHopital, String bloodType) throws EntityException;
    List<Bloods> findAllByBloodTypeIgnoreCase(String bloodType);
    List<Object>countQuantityByHopital(Long idHopital);
}
