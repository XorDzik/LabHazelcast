import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

import java.util.Map;
import java.util.Scanner;

public class HMapUpdate {
    public void updateAnimal(HazelcastInstance client) {
        IMap<Long, Zoo> animals = client.getMap( "zoo" );

        System.out.println("Podaj id: ");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();

        if (!animals.containsKey(Long.parseLong(id)))
            System.out.println("W zoo nie ma takiego zwierzęcia");
        else {
            System.out.println("Podaj gatunek: ");
            String type = scanner.nextLine();

            System.out.println("Podaj rodzinę: ");
            String family = scanner.nextLine();

            for (Map.Entry<Long, Zoo> e : animals.entrySet()) {
                if (e.getKey().toString().equals(id)) {
                    Zoo oldAnimal = new Zoo(e.getValue().getType(), e.getValue().getFamily());
                    Zoo newAnimal = new Zoo(type, family);
                    animals.replace(e.getKey(), oldAnimal, newAnimal);
                    System.out.println("Zaktualizowano " + e.getKey() + "=> " + oldAnimal.toString() +
                            " na => " + newAnimal.toString());
                }
            }
        }
    }
}
