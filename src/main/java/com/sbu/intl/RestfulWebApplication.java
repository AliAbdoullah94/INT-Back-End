package com.sbu.intl;

import com.sbu.intl.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestfulWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebApplication.class, args);

//		ConfigurableApplicationContext configurableApplicationContext =
//			SpringApplication.run(RestfulWebApplication.class, args);
//		FormRepository formRepository = configurableApplicationContext.getBean(FormRepository.class);
//		ApplicantRepository applicantRepository = configurableApplicationContext.getBean(ApplicantRepository.class);
//
//		Applicant applicant = new Applicant("A2@JAVA","1234","Syrian");
//		Form form = new Form(applicant,"Soft Eng",null,"some note");
//
//		applicantRepository.save(applicant);
//		formRepository.save(form);
	}

}
