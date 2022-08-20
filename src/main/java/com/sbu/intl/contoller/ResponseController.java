package com.sbu.intl.contoller;

import com.sbu.intl.model.Applicant;
import com.sbu.intl.model.Response;
import com.sbu.intl.service.ApplicantRepository;
import com.sbu.intl.service.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ResponseController {

    @Autowired
    private ResponseRepository responseRepository;

    @Autowired
    private ApplicantRepository applicantRepository;


    @PostMapping(path="/responses/{applicantEmail}")
    public ResponseEntity<Void> addResponse(@RequestBody Response response, @PathVariable("applicantEmail") String applicantEmail) {
        Applicant applicant = applicantRepository.findByEmail(applicantEmail);
//        Optional<Response> retrievedResponse = Optional.ofNullable(responseRepository.findByApplicant(applicant));
//        if (retrievedResponse.isPresent())
//            responseRepository.save(response);
        if(applicant.getResponse() != null){
            throw new IllegalArgumentException("applicant alre");
        }
        applicant.setResponse(response);
        response.setApplicant(applicant);
        responseRepository.save(response);
        applicantRepository.save(applicant);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path="/responses/{id}")
    public ResponseEntity<Void> updateResponse(@RequestBody Response response, @PathVariable("id") long id) {
        Optional<Response> retrieved = responseRepository.findById(id);
        if (retrieved.isPresent()){
            retrieved.orElseThrow().setResponseText(response.getResponseText());
            retrieved.orElseThrow().setAccepted(response.isAccepted());
            responseRepository.save(retrieved.get());
        }

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/responses/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteResponse(@PathVariable("id") Long id) {
        responseRepository.deleteById(id);
    }

    @GetMapping(path="/responses")
    public Iterable<Response> getResponses() {
        return responseRepository.findAll();
    }

    @GetMapping(path="/responses/{id}")
    public Optional<Response> getResponse(@PathVariable("id") Long id) {
        return responseRepository.findById(id);
    }

}

