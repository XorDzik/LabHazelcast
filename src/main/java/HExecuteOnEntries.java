import java.io.Serializable;
import java.net.UnknownHostException;
import java.util.Map.Entry;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import com.hazelcast.map.EntryProcessor;

public class HExecuteOnEntries {
	public void processData(HazelcastInstance client) {
		IMap<Long, Zoo> animals = client.getMap("zoo");
		animals.executeOnEntries(new HEntryProcessorType());

		for (Entry<Long, Zoo> e : animals.entrySet()) {
			System.out.println(e.getKey() + " => " + e.getValue());
		}
	}
}

class HEntryProcessorType implements EntryProcessor<Long, Zoo, String>, Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public String process(Entry<Long, Zoo> e) {
		Zoo animal = e.getValue();
		String animalType = animal.getType();
		String animalFamily = animal.getFamily();

		if (animalType.equals(animalType.toLowerCase()) && animalFamily.equals(animalFamily.toLowerCase())) {
			animalType = animalType.toUpperCase();
			animalFamily = animalFamily.toUpperCase();

			animal.setType(animalType);
			animal.setFamily(animalFamily);

		} else{
			animalType = animalType.toLowerCase();
			animalFamily = animalFamily.toLowerCase();

			animal.setType(animalType);
			animal.setFamily(animalFamily);
		}
		
		System.out.println("Processing = " + animal);
		e.setValue(animal);
		
		return animalType;
	}

}
