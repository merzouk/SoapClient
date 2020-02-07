package org.com.client.impl;

import org.com.client.PersonClient;
import org.com.wsdl.AddPersonRequest;
import org.com.wsdl.AddPersonResponse;
import org.com.wsdl.DeletePersonByIdRequest;
import org.com.wsdl.DeletePersonByIdResponse;
import org.com.wsdl.GetPersonByFirstNameRequest;
import org.com.wsdl.GetPersonByFirstNameResponse;
import org.com.wsdl.GetPersonByIdRequest;
import org.com.wsdl.GetPersonByIdResponse;
import org.com.wsdl.GetPersonByLastNameRequest;
import org.com.wsdl.GetPersonByLastNameResponse;
import org.com.wsdl.ReadListPersonRequest;
import org.com.wsdl.ReadListPersonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Service("personClient")
public class PersonClientImpl extends WebServiceGatewaySupport implements PersonClient
{

   private static final Logger logger = LoggerFactory.getLogger(PersonClientImpl.class);
	
   /**
    * 
    * @see org.com.client.PersonClient#readListPerson(org.com.wsdl.ReadListPersonRequest)
    */
   public ReadListPersonResponse readListPerson(ReadListPersonRequest request) 
   {

	       logger.info("Requesting location read all Person : " );
	       ReadListPersonResponse response = (ReadListPersonResponse) getWebServiceTemplate().marshalSendAndReceive(
	               "http://localhost:8383/personService/ws/person", request,
	               new SoapActionCallback("http://org.com/personService/ReadListPersonRequest"));
	       return response;
	   }
	
	
   /**
    * 
    * @see org.com.client.PersonClient#deletePersonById(org.com.wsdl.DeletePersonByIdRequest)
    */
	public DeletePersonByIdResponse deletePersonById(DeletePersonByIdRequest request) 
	{

       logger.info("Requesting location delete Person by id  : " + request.getId() );
       DeletePersonByIdResponse response = (DeletePersonByIdResponse) getWebServiceTemplate().marshalSendAndReceive(
               "http://localhost:8383/personService/ws/person", request,
               new SoapActionCallback("http://org.com/personService/DeletePersonByIdRequest"));
       return response;
   }
	/**
	 * 
	 * @see org.com.client.PersonClient#addPersonById(org.com.wsdl.AddPersonRequest)
	 */
	public AddPersonResponse addPersonById(AddPersonRequest request) 
	{

       logger.info("Requesting location add new Person : " + request.getNewPersonRequest().getFirstname() +"    "+ request.getNewPersonRequest().getLastname());
       AddPersonResponse response = (AddPersonResponse) getWebServiceTemplate().marshalSendAndReceive(
               "http://localhost:8383/personService/ws/person", request,
               new SoapActionCallback("http://org.com/personService/AddPersonRequest"));
       return response;
   }
	/**
	 * 
	 * @see org.com.client.PersonClient#getPersonById(java.lang.Integer)
	 */
	public GetPersonByIdResponse getPersonById(Integer id) 
	{

		GetPersonByIdRequest request = new GetPersonByIdRequest();
		request.setId(id);

		logger.info("Requesting location for id : " + id);

		GetPersonByIdResponse response = (GetPersonByIdResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:8383/personService/ws/person", request,
				new SoapActionCallback("http://org.com/personService/GetPersonByIdRequest"));

		return response;
	}
	
	/**
	 * 
	 * @see org.com.client.PersonClient#getListPersonByLastName(java.lang.String)
	 */
	public GetPersonByLastNameResponse getListPersonByLastName(String lastName) 
	{

		GetPersonByLastNameRequest request = new GetPersonByLastNameRequest();
		request.setLarstname("MENHOUR");

		logger.info("Requesting location for lastName : " + lastName);

		GetPersonByLastNameResponse response = (GetPersonByLastNameResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:8383/personService/ws/person", request,
				new SoapActionCallback("http://org.com/personService/GetPersonByLastNameRequest"));

		return response;
	}
	
	/**
	 * 
	 * @see org.com.client.PersonClient#getListPersonByFirstName(java.lang.String)
	 */
	public GetPersonByFirstNameResponse getListPersonByFirstName(String firstName) 
	{

		GetPersonByFirstNameRequest request = new GetPersonByFirstNameRequest();
		request.setFirstname("Merzouk");

		logger.info("Requesting location for firstName : " + firstName);

		GetPersonByFirstNameResponse response = (GetPersonByFirstNameResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:8383/personService/ws/person", request,
				new SoapActionCallback("http://org.com/personService/GetPersonByFirstNameRequest"));

		return response;
	}

}