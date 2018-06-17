package Cwiczenia4;

import Cwiczenia4.domain.Person;
import com.basho.riak.client.api.RiakClient;
import com.basho.riak.client.api.cap.UnresolvedConflictException;
import com.basho.riak.client.api.commands.kv.FetchValue;
import com.basho.riak.client.core.query.Location;
import com.basho.riak.client.core.query.Namespace;

import java.util.concurrent.ExecutionException;

/**
 * @author sadowsm3 on 17.06.2018
 */
public class RiakFunctions {

    public static Location generateLocationForKey(String key) {
        return new Location(new Namespace("s17983"), key);
    }

    public static Person getValueForKey(RiakClient client, Location location) throws ExecutionException, InterruptedException {
        FetchValue fv = new FetchValue.Builder(location).build();
        FetchValue.Response response = client.execute(fv);
        return response.getValue(Person.class);
    }

    
}
