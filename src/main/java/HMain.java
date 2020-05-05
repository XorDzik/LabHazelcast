import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import java.util.Scanner;

public class HMain {
    public static void main(String[] args) {
        HazelcastInstance client = Hazelcast.newHazelcastInstance();
        System.out.println("Aplikacja ma za zadanie pokazać działanie składu Hazelcat");
        System.out.println("Temat: zoo");

        HMapPut put = new HMapPut();
        HMapUpdate update = new HMapUpdate();
        HMapDrop drop = new HMapDrop();
        HMapGet get = new HMapGet();
        HPredicate hPredicate = new HPredicate();
        HExecuteOnEntries process = new HExecuteOnEntries();

        for (;;) {
            System.out.println("1 -> Dodaj dane");
            System.out.println("2 -> Aktualizuj dane");
            System.out.println("3 -> Kasuj dane");
            System.out.println("4 -> Pobierz wszystkie dane");
            System.out.println("5 -> Pobierz dane po id");
            System.out.println("6 -> Pobierz wszystkie zwierzęta danego gatunku");
            System.out.println("7 -> Przetwórz dane");
            System.out.println("8 -> Zakończ program");

            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();

            if (choice.equals("1"))
                put.putData(client);

            if (choice.equals("2"))
                update.updateAnimal(client);

            if (choice.equals("3"))
                drop.dropAnimalById(client);

            if (choice.equals("4"))
                get.getAllAnimals(client);

            if (choice.equals("5"))
                get.getAnimalById(client);

            if (choice.equals("6"))
                hPredicate.getByType(client);

            if (choice.equals("7"))
                process.processData(client);

            if (choice.equals("8"))
                break;
        }

        client.shutdown();
    }
}
