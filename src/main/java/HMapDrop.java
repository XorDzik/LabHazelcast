import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

import java.util.Map;
import java.util.Scanner;

public class HMapDrop {
    public void dropAnimalById(HazelcastInstance client) {
        IMap<Long, Zoo> animals = client.getMap( "zoo" );

        System.out.println("Podaj id zwierzęcia które chcesz usunąć: ");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();

        if (!animals.containsKey(Long.parseLong(id)))
            System.out.println("W zoo nie ma takiego zwierzęcia");
        else {
            for (Map.Entry<Long, Zoo> e : animals.entrySet()) {
                if (e.getKey().toString().equals(id)) {
                    animals.remove(e.getKey());
                    System.out.println("Usunięto ze składu następujący element: "
                            + e.getKey() + " => " + e.getValue());
                }
            }
        }
    }
}
