
package org.com.person;

import org.com.client.PersonClient;
import org.com.wsdl.GetPersonByIdResponse;
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
 * @date    : 7 févr. 2020 11:51:19
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = { org.com.config.PersonConfiguration.class })
public class ReadPersonById
{
   @Autowired
   private PersonClient personClient;
   @Test
   public void readByIdTest()
   {
      GetPersonByIdResponse response = personClient.getPersonById( 1 );
      System.out.println( response.getPersonById().getFirstname() + "     " + response.getPersonById().getLastname() + "     " + response.getPersonById().getId() );
   }
}
