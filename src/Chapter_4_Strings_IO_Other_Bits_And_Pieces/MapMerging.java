package Chapter_4_Strings_IO_Other_Bits_And_Pieces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapMerging {

	public static void main(String[] args) {
		
		List<PersonForMap> persons = new ArrayList<>();
		
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(MapMerging.class.getResourceAsStream("personsForMap.txt")));
				Stream<String> stream = reader.lines();
				){
			
			stream.map(line -> {
				String[] s = line.split(" ");
				PersonForMap person = new PersonForMap(s[0].trim(), Integer.parseInt(s[1]), s[2].trim());
				persons.add(person);
				return person;
			})
			.forEach(System.out::println);
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		List<PersonForMap> list1 = persons.subList(0, 7);
		//*** list.sublist(from, to) ia elementele incepand de la "from" inclusiv si pana la "too" exclusiv
		List<PersonForMap> list2 = persons.subList(7, persons.size());
		
		Map<Integer, List<PersonForMap>> map1 = mapByAge(list1);
		System.out.println("Map 1");
		map1.forEach((age, list) -> System.out.println(age + " ---> " + list));
		Map<Integer, List<PersonForMap>> map2 = mapByAge(list2);
		System.out.println("Map 2");
		map2.forEach((age, list) -> System.out.println(age + " ---> " + list));
		
		map2.entrySet().stream()
			.forEach(entry -> {
				map1.merge(
						entry.getKey(), 
						entry.getValue(), 
						(l1, l2) -> {
							l1.addAll(l2);
							return l1;
						});
			});
			
		//Check if the mapping took place
		System.out.println("Map 1 merged: ");
		map1.forEach((age, list) -> System.out.println(age + " ---> " + list));
		
		//###***### 
		//BiMap example
		
		Map<Integer, Map<String, List<PersonForMap>>> biMap = new HashMap<>();
		
		persons.stream()
			.forEach(person ->{
				biMap.computeIfAbsent(person.getAge(), HashMap::new)
						.merge(
								person.getGender(), 
								new ArrayList<PersonForMap>(Arrays.asList(person)), 
								(l1, l2) ->{
									l1.addAll(l2);
									return l1;
								}								
								);
						
			});
		
		//BiMap:
		System.out.println("BiMap: ");
		biMap.forEach((age, map) -> System.out.println(age + " ---> " + map));
		
		
		
	}
	
	private static Map<Integer, List<PersonForMap>> mapByAge(List<PersonForMap> list){
		return list.stream()
				.collect(Collectors.groupingBy(PersonForMap::getAge));
	}

}
