package com.shablobank.app.service;

import com.shablobank.app.Exception.EntityException;
import com.shablobank.app.models.Analyse;
import com.shablobank.app.models.Hopital;
import com.shablobank.app.repository.IAnalyseRepository;
import com.shablobank.app.repository.IHopitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AnalyseService implements  IAnalyseService{
    @Autowired
    private IAnalyseRepository analyseRepository;
    @Override
    public Analyse saveAnalyse(Analyse analyse) {
        return analyseRepository.save(analyse);
    }

    @Override
    public List<Analyse> fetchAnalyseList() {
        return analyseRepository.findAll();
    }

    @Override
    public Analyse fetchAnalyse(Long idAnalyse) throws EntityException {
        Optional<Analyse> analyse = analyseRepository.findById(idAnalyse);
        if (!analyse.isPresent()) {
            throw new EntityException("Analyse not found");
        }
        return analyse.get();
    }

    @Override
    public void deleteAnalyse(Long idAnalyse) throws EntityException {
        Optional<Analyse> analyse = analyseRepository.findById(idAnalyse);
        if (!analyse.isPresent()) {
            throw new EntityException("Analyse not available ");
        }
        analyseRepository.deleteById(idAnalyse);
    }

    @Override
    public Analyse updateAnalyse(Long idAnalyse, Analyse analyse) throws EntityException {
        Optional<Analyse> findAnalyse = analyseRepository.findById(idAnalyse);
        if (!findAnalyse.isPresent()) {
            throw new EntityException("No value present");
        }

        Analyse analyseDb = analyseRepository.findById(idAnalyse).get();
        if(Objects.nonNull(analyse.getLibelle()) &&!"".equalsIgnoreCase(analyse.getLibelle())){
            analyseDb.setLibelle(analyse.getLibelle());
        }
        return analyseRepository.save(analyseDb);
    }
}
