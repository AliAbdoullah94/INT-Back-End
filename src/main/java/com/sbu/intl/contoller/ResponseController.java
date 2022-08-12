package com.sbu.intl.contoller;

import com.sbu.intl.model.Applicant;
import com.sbu.intl.model.Form;
import com.sbu.intl.model.Response;
import com.sbu.intl.service.ApplicantRepository;
import com.sbu.intl.service.FormRepository;
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

    @Autowired
    private FormRepository formRepository;

    @PostMapping(path="/responses/{applicantEmail}")
    public ResponseEntity<Void> addResponse(@RequestBody Response response, @PathVariable("applicantEmail") String applicantEmail) {
        Applicant applicant = applicantRepository.findByEmail(applicantEmail);
        Form retrievedForm = formRepository.findByApplicant(applicant);
//        Optional<Response> retrievedResponse = Optional.ofNullable(responseRepository.findByApplicant(applicant));
//        if (retrievedResponse.isPresent())
//            responseRepository.save(response);
        response.setApplicant(applicant);
        response.setOnForm(retrievedForm);
        responseRepository.save(response);
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

