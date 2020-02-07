
package org.com;

import java.util.List;

import org.com.client.impl.PersonClientImpl;
import org.com.wsdl.AddPersonRequest;
import org.com.wsdl.AddPersonResponse;
import org.com.wsdl.DeletePersonByIdRequest;
import org.com.wsdl.DeletePersonByIdResponse;
import org.com.wsdl.GetPersonByFirstNameResponse;
import org.com.wsdl.GetPersonByIdResponse;
import org.com.wsdl.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientManageApplication
{
   public static void main( String[] args )
   {
      SpringApplication.run( ClientManageApplication.class, args );
   }
 
   @Bean
   CommandLineRunner lookup( PersonClientImpl quotePerson )
   {
      return args -> {
         String firstName = "Merzouk";
         if( args.length > 0 )
         {
            firstName = args[0];
         }
         GetPersonByFirstNameResponse response = quotePerson.getListPersonByFirstName( firstName );
         List<Person> list = response.getPersonvalues().getPerson();
         System.out.println( "----------------->   " + list.size() );
         for( Person person : list )
         {
            System.out.println( person.getId() + "    " + person.getFirstname() + "    " + person.getLastname() );
         }
         int id = 1;
         if( args.length > 0 )
         {
            id = Integer.parseInt( args[0] );
         }
         GetPersonByIdResponse response1 = quotePerson.getPersonById( id );
         System.err.println( response1.getPersonById().getFirstname() + "  " + response1.getPersonById().getLastname() + "    " + response1.getPersonById().getId() );
         id = 2;
         if( args.length > 0 )
         {
            id = Integer.parseInt( args[0] );
         }
         response1 = quotePerson.getPersonById( id );
         System.err.println( response1.getPersonById().getFirstname() + "  " + response1.getPersonById().getLastname() + "    " + response1.getPersonById().getId() );
         id = 3;
         if( args.length > 0 )
         {
            id = Integer.parseInt( args[0] );
         }
         response1 = quotePerson.getPersonById( id );
         System.err.println( response1.getPersonById().getFirstname() + "  " + response1.getPersonById().getLastname() + "    " + response1.getPersonById().getId() );
         AddPersonRequest request = new AddPersonRequest();
         Person person = new Person();
         person.setFirstname( "Tiziri" );
         person.setLastname( "MENHOUR" );
         request.setNewPersonRequest( person );
         AddPersonResponse respo = quotePerson.addPersonById( request );
         System.out.println( "retour person ajoutee id : " + respo.getNewPersonResponse().getId() + "   " + respo.getNewPersonResponse().getFirstname() + "    " + respo.getNewPersonResponse().getLastname() );
         /**
          * 
          */
         DeletePersonByIdRequest req = new DeletePersonByIdRequest();
         req.setId( 28 );
         DeletePersonByIdResponse res = quotePerson.deletePersonById( req );
         System.out.println( res.getResult() );
      };
   }
}
