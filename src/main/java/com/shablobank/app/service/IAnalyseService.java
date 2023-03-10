package com.shablobank.app.service;

import com.shablobank.app.Exception.EntityException;
import com.shablobank.app.models.Analyse;
import com.shablobank.app.models.Analyse;

import java.util.List;

public interface IAnalyseService {
    public Analyse saveAnalyse(Analyse analyse);

    List<Analyse> fetchAnalyseList();

    Analyse fetchAnalyse(Long idAnalyse) throws EntityException;

    void deleteAnalyse(Long idAnalyse) throws EntityException;

    Analyse updateAnalyse(Long idAnalyse, Analyse analyse) throws EntityException;

}
