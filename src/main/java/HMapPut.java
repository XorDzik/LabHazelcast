import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import com.hazelcast.core.HazelcastInstance;

public class HMapPut {

	final private static Random r = new Random(System.currentTimeMillis());

	public void putData(HazelcastInstance client) {
		Map<Long, Zoo> zoo = client.getMap("zoo");

		System.out.println("Podaj gatunek zwierzęcia: ");
		Scanner scanner = new Scanner(System.in);
		String animalType = scanner.nextLine();

		System.out.println("Podaj rodzinę zwierzęcia: ");
		String animalFamily = scanner.nextLine();

		Long key1 = (long) Math.abs(r.nextInt());
		Zoo animal = new Zoo(animalType, animalFamily);
		System.out.println("Dodano " + key1 + " => " + animal);
		zoo.put(key1, animal);
	}
}