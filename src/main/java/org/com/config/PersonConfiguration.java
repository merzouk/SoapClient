package org.com.config;

import org.com.client.impl.PersonClientImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class PersonConfiguration {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("org.com.wsdl");
		return marshaller;
	}

	@Bean
	public PersonClientImpl personClient(Jaxb2Marshaller marshaller) {
		PersonClientImpl client = new PersonClientImpl();
		client.setDefaultUri("http://localhost:8383/personService/ws");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
