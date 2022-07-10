package com.sbu.intl;

import com.sbu.intl.model.Applicant;
import com.sbu.intl.model.Form;
import com.sbu.intl.service.ApplicantRepository;
import com.sbu.intl.service.FormRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RestfulWebApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext configurableApplicationContext =
			SpringApplication.run(RestfulWebApplication.class, args);
		FormRepository formRepository = configurableApplicationContext.getBean(FormRepository.class);
		ApplicantRepository applicantRepository = configurableApplicationContext.getBean(ApplicantRepository.class);

		Applicant applicant = new Applicant("A2@JAVA","1234","Syrian");
		Form form = new Form(applicant,"Soft Eng",null,"some note");

		applicantRepository.save(applicant);
		formRepository.save(form);
	}

}
