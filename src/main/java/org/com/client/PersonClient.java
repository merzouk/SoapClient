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
 * Fichier 		:	PersonClient.java
 * Créé le 		: 	7 févr. 2020 à 15:00:42
 * Auteur		: 	Merzouk
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package org.com.client;

import org.com.wsdl.AddPersonRequest;
import org.com.wsdl.AddPersonResponse;
import org.com.wsdl.DeletePersonByIdRequest;
import org.com.wsdl.DeletePersonByIdResponse;
import org.com.wsdl.GetPersonByFirstNameResponse;
import org.com.wsdl.GetPersonByIdResponse;
import org.com.wsdl.GetPersonByLastNameResponse;
import org.com.wsdl.ReadListPersonRequest;
import org.com.wsdl.ReadListPersonResponse;

/**
 * A Renseigner.
 * @author  : Merzouk
 * @project : clientManage
 * @package : org.com.client
 * @date    : 7 févr. 2020 15:00:42
 */
public interface PersonClient
{
   /**
    * 
    * @param request
    * @return
    */
   public ReadListPersonResponse readListPerson( ReadListPersonRequest request );
   
   /**
    * 
    * @param request
    * @return
    */
   public DeletePersonByIdResponse deletePersonById( DeletePersonByIdRequest request );
   
   /**
    * 
    * @param request
    * @return
    */
   public AddPersonResponse addPersonById( AddPersonRequest request );
   
   /**
    * 
    * @param id
    * @return
    */
   public GetPersonByIdResponse getPersonById( Integer id );
   
   /**
    * 
    * @param lastName
    * @return
    */
   public GetPersonByLastNameResponse getListPersonByLastName( String lastName );
   
   /**
    * 
    * @param firstName
    * @return
    */
   public GetPersonByFirstNameResponse getListPersonByFirstName( String firstName );
}
