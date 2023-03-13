package com.shablobank.app.service;

import com.shablobank.app.Exception.EntityException;
import com.shablobank.app.models.Bloods;

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
}
