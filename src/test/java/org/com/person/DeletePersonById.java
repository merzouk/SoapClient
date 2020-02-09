package org.com.person;

import org.com.client.PersonClient;
import org.com.wsdl.DeletePersonByIdRequest;
import org.com.wsdl.DeletePersonByIdResponse;
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
 * @date    : 7 févr. 2020 11:58:33
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = { org.com.config.PersonConfiguration.class })
public class DeletePersonById
{
   @Autowired
   private PersonClient personClient;
   @Test
   public void deleteByIdTest()
   {
      DeletePersonByIdRequest request = new DeletePersonByIdRequest();
      request.setId( 26 );
      DeletePersonByIdResponse response = personClient.deletePersonById( request );
      System.out.println( response.getResult() );
   }
}
