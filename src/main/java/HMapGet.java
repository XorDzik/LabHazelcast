import java.util.Map.Entry;
import java.util.Scanner;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

public class HMapGet {
    public void getAllAnimals(HazelcastInstance client) {
        IMap<Long, Zoo> animals = client.getMap( "zoo" );

        if (!animals.isEmpty()) {
            System.out.println("Wszystkie zwierzęta: ");
            for (Entry<Long, Zoo> e : animals.entrySet()) {
                System.out.println(e.getKey() + " => " + e.getValue());
            }
        } else
            System.out.println("W zoo nie ma żadnych zwierząt");
    }

    public void getAnimalById(HazelcastInstance client) {
        IMap<Long, Zoo> animals = client.getMap( "zoo" );

        System.out.println("Podaj id: ");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();

        if (!animals.containsKey(Long.parseLong(id)))
            System.out.println("W zoo nie ma takiego zwierzęcia");
        else {
            for (Entry<Long, Zoo> e : animals.entrySet()) {
                if (e.getKey().toString().equals(id))
                    System.out.println(e.getKey() + " => " + e.getValue());
            }
        }
    }
}