
package org.com.person;

import java.util.List;

import org.com.client.PersonClient;
import org.com.wsdl.GetPersonByFirstNameResponse;
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
 * @date    : 7 févr. 2020 12:25:34
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = { org.com.config.PersonConfiguration.class })
public class ReadPersonByFirstName
{
   @Autowired
   private PersonClient personClient;
   @Test
   public void readPersonByFirstNameTest()
   {
      GetPersonByFirstNameResponse response = personClient.getListPersonByFirstName( "Merzouk" );
      List<Person> list = response.getPersonvalues().getPerson();
      for( Person person : list )
      {
         System.out.println( person.getFirstname() + "     " + person.getLastname() + "     " + person.getId() );
      }
   }
}
