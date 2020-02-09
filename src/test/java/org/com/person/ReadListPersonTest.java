package org.com.person;

import java.util.List;

import org.com.client.PersonClient;
import org.com.wsdl.Person;
import org.com.wsdl.ReadListPersonRequest;
import org.com.wsdl.ReadListPersonResponse;
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
 * @date    : 7 févr. 2020 12:02:18
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = { org.com.config.PersonConfiguration.class })
public class ReadListPersonTest
{
   @Autowired
   private PersonClient personClient;
   @Test
   public void readByIdTest()
   {
      ReadListPersonRequest request = new ReadListPersonRequest();
      ReadListPersonResponse response = personClient.readListPerson( request );
      List<Person> listPerson = response.getPersonValues().getPerson();
      for( Person person : listPerson )
      {
         System.out.println( person.getFirstname() + "     " + person.getLastname() + "     " + person.getId() );
      }
   }
}
