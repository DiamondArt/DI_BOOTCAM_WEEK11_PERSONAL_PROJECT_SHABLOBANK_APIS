package com.shablobank.app.service;

import com.shablobank.app.controller.exception.EntityException;
import com.shablobank.app.models.Bloods;
import com.shablobank.app.models.Hopital;
import com.shablobank.app.repository.IBloodRepository;
import com.shablobank.app.repository.IHopitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BloodService implements IBloodService{

    @Autowired
    private IHopitalRepository hopitalRepository;

    @Autowired
    private IBloodRepository bloodRepository;

    @Override
    public Bloods saveBloods(Bloods bloods) {
        return bloodRepository.save(bloods);
    }

    @Override
    public List<Bloods> fetchAllBloodsList() {
        return bloodRepository.findAll();
    }

    @Override
    public Bloods fetchBloods(Long idBloods) throws EntityException {
        Optional<Bloods> bloods = bloodRepository.findById(idBloods);
        if (!bloods.isPresent()) {
            throw new EntityException("Item not found");
        }
        return bloods.get();
    }

    @Override
    public void deleteBloods(Long idBloods) throws EntityException {
        Optional<Bloods> bloods = bloodRepository.findById(idBloods);
        if (!bloods.isPresent()) {
            throw new EntityException("Item not available ");
        }
        bloodRepository.deleteById(idBloods);
    }

    @Override
    public Bloods updateBloods(Long idBloods, Bloods blood) throws EntityException {
        return null;
    }

    @Override
    public List<Bloods> findAllByHopital(Long idHopital) throws EntityException {
        Optional<Hopital> hopital = hopitalRepository.findById(idHopital);
        if (!hopital.isPresent()) {
            throw new EntityException("Item not available ");
        }
        return bloodRepository.findAllByHopital(idHopital);
    }

    @Override
    public List<Bloods> findAllByHopitalAndBloodTypeIgnoreCase(Long idHopital, String bloodType) throws EntityException {

        Optional<Hopital> hopital = hopitalRepository.findById(idHopital);
        if (!hopital.isPresent()) {
            throw new EntityException("Item not available ");
        }
        return bloodRepository.findAllByHopitalAndBloodTypeIgnoreCase(idHopital, bloodType);
    }

    @Override
    public List<Bloods> findAllByBloodTypeIgnoreCase(String bloodType) {
        return bloodRepository.findAllByBloodTypeIgnoreCase(bloodType);
    }
}
