package com.sbu.intl.contoller;

import com.sbu.intl.model.Applicant;
import com.sbu.intl.model.Log;
import com.sbu.intl.service.ApplicantRepository;
import com.sbu.intl.service.LogRepository;
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
    
    @PostMapping(path = "/logs")
    public ResponseEntity<Void> addLog(@RequestBody Log log) {
        Applicant applicant = applicantRepository.findByEmail(log.getApplicant().getEmail());
        Log logEntity = new Log(log.getLogType(),applicant,log.getDateCreated());
        logRepository.save(logEntity);
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


