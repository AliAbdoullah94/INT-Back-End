package com.sbu.intl.contoller;

import com.sbu.intl.model.Applicant;
import com.sbu.intl.model.Form;
import com.sbu.intl.model.Log;
import com.sbu.intl.model.Response;
import com.sbu.intl.service.ApplicantRepository;
import com.sbu.intl.service.FormRepository;
import com.sbu.intl.service.LogRepository;
import com.sbu.intl.service.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LogController {

    @Autowired
    private LogRepository logRepository;

    @Autowired
    private ApplicantRepository applicantRepository;

    @Autowired
    private FormRepository formRepository;

    @Autowired
    private ResponseRepository responseRepository;
    
    @PostMapping(path = "/logs/{type}")
    public ResponseEntity<Void> addLog(@RequestBody Log log, @PathVariable("type") String type) {
        if (type.equals("signUp")){
            Applicant applicant = applicantRepository.findByEmail(log.getApplicant().getEmail());
            Log logEntity = new Log(log.getLogType(),applicant,log.getDateCreated());
            logRepository.save(logEntity);
        }
        else if (type.equals("apply")){
            Applicant applicant = applicantRepository.findByEmail(log.getApplicant().getEmail());
            Form form = formRepository.findByApplicant(applicant);
            Log logEntity = new Log(log.getLogType(),applicant,form,log.getDateCreated());
            logRepository.save(logEntity);
        }
        // response
        else {
            Applicant applicant = applicantRepository.findByEmail(type);
            Response response = responseRepository.findByApplicant(applicant);
            Log logEntity = new Log(log.getLogType(),applicant,response,log.getDateCreated());
            logRepository.save(logEntity);
        }
        return ResponseEntity.noContent().build();
    }



    @PutMapping(path = "/logs/{id}")
    public ResponseEntity<Void> updateLog(@RequestBody Log log, @PathVariable("id") Long id) {
        Optional<Log> retrieved = logRepository.findById(id);
        if (retrieved.isPresent())
            logRepository.save(log);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/logs/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteLog(@PathVariable("id") Long id) {
        logRepository.deleteById(id);
    }

    @GetMapping(path = "/logs")
    public Iterable<Log> getLogs() {
        return logRepository.findAll();
    }

    @GetMapping(path = "/logs/{id}")
    public Optional<Log> getLog(@PathVariable("id") Long id) {
        return logRepository.findById(id);
    }

}


