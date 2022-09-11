package com.calisto.spring.rest_api;

import com.calisto.spring.rest_api.entity.Company;
import com.calisto.spring.rest_api.entity.Tender;
import com.calisto.spring.rest_api.forms.rosneft.DocGeneratorsPDF;
import com.calisto.spring.rest_api.forms.rosneft.GeneratorDocForm1a;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
		GeneratorDocForm1a doc = new GeneratorDocForm1a();
		doc.launch(new Company(),"C:\\java\\blank\\forms2\\123.pdf", new Tender());
	}
}
