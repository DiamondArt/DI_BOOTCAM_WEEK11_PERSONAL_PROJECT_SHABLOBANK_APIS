package com.shablobank.app.controller;

import com.shablobank.app.controller.exception.EntityException;
import com.shablobank.app.models.Analyse;
import com.shablobank.app.repository.IAnalyseRepository;
import com.shablobank.app.service.AnalyseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/analyse")
@CrossOrigin("*")
public class AnalyseController {
  
        @Autowired
        private IAnalyseRepository analyseRepository;
        @Autowired
        private AnalyseService analyseService;
        private final Logger LOGGER = LoggerFactory.getLogger(com.shablobank.app.controller.AnalyseController.class);

        @GetMapping()
        public List<Analyse> fetchAnalyse() {
            return analyseService.fetchAnalyseList();
        }

        @GetMapping("{id}")
        public Analyse fetchAnalyseById(@PathVariable("id") Long idAnalyse) throws EntityException {

            LOGGER.info("Inside fetchAnalyseAnalyse AnalyseController ");
            return analyseService.fetchAnalyse(idAnalyse);
        }

        @DeleteMapping("{id}")
        public String deleteAnalyse(@PathVariable("id") Long idAnalyse) throws EntityException{
            LOGGER.info("Inside delteAnalyse AnalyseController ");

            analyseService.deleteAnalyse(idAnalyse);
            return "Delete successfull";
        }

        @PostMapping()
        public Analyse saveAnalyse(@Validated @RequestBody Analyse analyse) {
            LOGGER.info("Inside SaveAnalyse AnalyseController ");
            return analyseService.saveAnalyse(analyse);
        }

        @PutMapping("{id}")
        public Analyse updateAnalyse(@PathVariable("id") Long idAnalyse, @Valid @RequestBody Analyse analyse) throws EntityException{
            LOGGER.info("Inside updateAnalyse AnalyseController ");
            return  analyseService.updateAnalyse(idAnalyse, analyse);
        }
}
