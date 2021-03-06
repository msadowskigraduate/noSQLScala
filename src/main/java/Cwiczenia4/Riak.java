package Cwiczenia4;

import Cwiczenia4.domain.Person;
import Cwiczenia4.domain.PersonUpdate;
import com.basho.riak.client.api.RiakClient;
import com.basho.riak.client.core.query.Location;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutionException;
import static Cwiczenia4.RiakFunctions.*;

/**
 * @author sadowsm3 on 17.06.2018
 */

public class Riak {
    public static void main(String[] args) throws UnknownHostException, ExecutionException, InterruptedException {

        System.out.println("GENERATING CLIENT...");

        RiakClient riakClient = RiakClient.newClient(8098, "localhost");

        System.out.println("CLIENT GENERATED SUCCESSFULLY!");
        RiakFunctions.performPreRunCleanup(riakClient);
        Location testResourceKey = generateLocationForKey("Test");
        System.out.println("CREATING NEW RESOURCE:");
        Person person = new Person();
        person.setId("6");
        person.setFirstName("Test");
        person.setLastName("McTest");
        person.setBorn(2018);
        person.setSalary(9999.99f);
        System.out.println(person.toString());
        System.out.println(addNewEntryWithKey(riakClient, testResourceKey, person));

        System.out.println("UPDATE RESOURCE WITH NEW VALUES");
        PersonUpdate update = new PersonUpdate(null, "NewFirstName", "NewLastName", 2017, 789f);
        System.out.println(modifyEntryByKey(riakClient,testResourceKey ,update));

        System.out.println("NEW RESOURCE VALUES AS TAKEN FROM RIAK: ");
        System.out.println(getValueForKey(riakClient, testResourceKey).toString());

        System.out.println("DELETING NEW RESOURCE: ");
        System.out.println(deleteEntryForKey(riakClient, testResourceKey));


    }
}
