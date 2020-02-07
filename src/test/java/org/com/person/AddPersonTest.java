/*
 *--------------------------------------------------------
 * Administrateur
 *--------------------------------------------------------
 * Project     : clientManage
 *
 * Copyright Administrateur,  All Rights Reserved.
 *
 * This software is the confidential and proprietary
 * information of Administrateur.
 * You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms
 * of the license agreement you entered into with
 * Administrateur.
 *-------------------------------------------------------- 
 * 
 * Fichier 		:	AddPersonTest.java
 * Créé le 		: 	7 févr. 2020 à 12:20:45
 * Auteur		: 	Merzouk
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package org.com.person;

import org.com.client.PersonClient;
import org.com.wsdl.AddPersonRequest;
import org.com.wsdl.AddPersonResponse;
import org.com.wsdl.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * A Renseigner.
 * @author  : Merzouk
 * @project : clientManage
 * @package : org.com
 * @date    : 7 févr. 2020 12:20:45
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = { org.com.config.PersonConfiguration.class })
public class AddPersonTest
{
   @Autowired
   private PersonClient personClient;
   @Test
   public void addPersonTest()
   {
      AddPersonRequest request = new AddPersonRequest();
      Person person = new Person();
      person.setFirstname( "Moha" );
      person.setLastname( "MENHOUR" );
      person.setId( 31 );
      request.setNewPersonRequest( person );
      AddPersonResponse response = personClient.addPersonById( request );
      System.out.println( response.getNewPersonResponse().getId() + "  " + response.getNewPersonResponse().getFirstname() + "    " + response.getNewPersonResponse().getLastname() );
   }
}
