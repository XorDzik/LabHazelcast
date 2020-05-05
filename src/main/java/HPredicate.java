import java.util.Collection;
import java.util.Scanner;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import com.hazelcast.query.Predicate;
import com.hazelcast.query.Predicates;

public class HPredicate {

	public void getByType(HazelcastInstance client) {
		IMap<Long, Zoo> animals = client.getMap("zoo");

		System.out.println("Podaj gatunek zwierzęcia");
		Scanner scanner = new Scanner(System.in);
		String type = scanner.nextLine();

		Predicate<?,?> familyPredicate = Predicates.alwaysTrue();
		Predicate<?,?> typePredicate = Predicates.equal("type", type);

		Collection<Zoo> oneTypeAnimals = animals.values(Predicates.and(typePredicate, familyPredicate));
		for (Zoo s : oneTypeAnimals) {
			System.out.println(s);
		}
	}
}
