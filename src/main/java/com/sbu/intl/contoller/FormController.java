package com.sbu.intl.contoller;

import com.sbu.intl.dto.FormDTO;
import com.sbu.intl.model.Applicant;
import com.sbu.intl.model.Form;
import com.sbu.intl.service.ApplicantRepository;
import com.sbu.intl.service.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FormController {

    @Autowired
    private FormRepository formRepository;

    @Autowired
    private ApplicantRepository applicantRepository;

    //    @PostMapping(path = "/forms")
//    public ResponseEntity<Void> addForm(@RequestBody FormDTO formDTO) {
//        Applicant applicant = Optional.ofNullable(formDTO.getApplicant())
//                .flatMap(id -> applicantRepository.findById(id))
//                .orElseThrow(()-> new IllegalArgumentException("Form applicant shouldn't be null"));
//        Form formEntity = new Form(applicant,formDTO.getApplyFor(), formDTO.getDateCreated(), formDTO.getNotes());
//        formRepository.save(formEntity);
//        return ResponseEntity.noContent().build();
//    }
    @PostMapping(path = "/forms")
    public ResponseEntity<Void> addForm(@RequestBody Form form) {
        Applicant applicant = applicantRepository.findByEmail(form.getApplicant().getEmail());
        Form formEntity = new Form(applicant, form.getApplyFor(), form.getDateCreated(), form.getAboutApplicant());
        formRepository.save(formEntity);
        return ResponseEntity.noContent().build();
    }


    @PutMapping(path = "/forms/{id}")
    public ResponseEntity<Void> updateForm(@RequestBody Form form, @PathVariable("id") Long id) {
        Optional<Form> retrieved = formRepository.findById(id);
        if (retrieved.isPresent())
            formRepository.save(form);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/forms/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteForm(@PathVariable("id") Long id) {
        formRepository.deleteById(id);
    }

    @GetMapping(path = "/forms")
    public Iterable<Form> getForms() {
        return formRepository.findAll();
    }

    @GetMapping(path = "/forms/{id}")
    public Optional<Form> getForm(@PathVariable("id") Long id) {
        return formRepository.findById(id);
    }

}

