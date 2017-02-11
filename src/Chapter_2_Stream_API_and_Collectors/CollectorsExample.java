package Chapter_2_Stream_API_and_Collectors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class CollectorsExample {

	public static void main(String[] args) {
		
		List<Person> persons = new ArrayList<Person>();
		
		try(BufferedReader reader = new BufferedReader(
						new InputStreamReader(CollectorsExample.class.getResourceAsStream("persons.txt")));
				
				Stream<String> personsStream = reader.lines();
				){
			
			personsStream.map(line -> {
				String[] str = line.split(" ");
				Person p = new Person(str[0], Integer.parseInt(str[1]));
				persons.add(p);
				return p;
					})
				.forEach(System.out::println);
				//.forEach(p -> persons.add(p));
			
			System.out.println("persons list size " + persons.size());
			
			//==================================================================
			//Find out the age of the youngest person older than 20
			//==================================================================
			
			
			//###***### 
			//Definirea unei variabile stream ca mai jos poate cauza erori deoarece vom avea tendinta sa folosim aceasta variabile in mai multe procesari
			//(ceea ce nu avem voie) deoarece putem efectua o singura operatie finala pe un stream deschis. Daca vrem sa facem si alte operatii finale trebuie
			//sa redeschidem stream-ul
			//Stream<Person> stream1 = persons.stream();
			
//			Optional<Person> youngestPersonOlderThan20 = stream1
//					.filter(pers -> pers.getAge() > 20)
//					.min(Comparator.comparing(Person::getAge));
			
			Optional<Person> youngestPersonOlderThan20 = persons.stream()
				.filter(pers -> pers.getAge() > 20)
				.min(Comparator.comparing(Person::getAge));
			
			System.out.println("The youngest person older than 20 is: " + youngestPersonOlderThan20);
			
			//==================================================================
			//Find the oldest person
			//==================================================================
			//###***### Daca incercam sa folosim acelasi stream ca mai sus (stream1) va aparea o eroare la  runtime atunci can incercam sa mai procesam o data datele din acel stream
			// "...stream has already been operated upon...."
			//###***### Nu putem apela 2 metode finale pe acelasi stream. Odata ce un stream a fost folosit pt a procesa un set de date nu poate fi refolosit
			//###***### Trebuie sa cream alt stream (practic redeschidem stream-ul) care sa fie conectat la aceeasi sursa de date si apoi sa apelam pe el operatiile necesare
			//###***### Un stream nu contine date, deci crearea lui si declararea de operatii pe el este un proces foarte "light"
			
			//Varianta de cod care da eroarea mentionata mai sus			
//			Optional<Person> oldestPerson = 
//					stream1.max(Comparator.comparing(Person::getAge));
			
			//Varianta functionala
			Optional<Person> oldestPerson = persons
					.stream()
					.max(Comparator.comparing(Person::getAge));
			
			System.out.println("The oldest person is: " + oldestPerson);
			
			//==================================================================
			//Collectors example 1
			//Persons grouped by ages
			//==================================================================
			
			Map<Integer, List<Person>> map = persons.stream()
					.collect(Collectors.groupingBy(Person::getAge));
			
			System.out.println(map);

			//==================================================================
			//Collectors example 2
			//Numarul persoanelor de o anumita varsta
			//Folosim "DOWNSTREAM COLLECTORS"
			//==================================================================
			
			Map<Integer, Long> map2 = persons
					.stream()
					.collect(Collectors.groupingBy(Person::getAge, Collectors.counting()));
			
			System.out.println("map2 = " + map2);
			
			
			//==================================================================
			//Collectors example 3
			//Numele persoanelor care au o anumita varsta grupate dupa varsta
			//Folosim "DOWNSTREAM COLLECTORS"
			//==================================================================
			
			Map<Integer, List<String>> map3 = persons
					.stream()
					.collect(Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.toList())));
			
			System.out.println("map3 = " + map3);
			
			
			//==================================================================
			//Collectors ex 4
			//Numele persoanelor care au o anumita varsta grupate dupa varsta in ordine alfabetica
			//Folosim "DOWNSTREAM COLLECTORS"
			//==================================================================
			
			Map<Integer, Set<String>> map4 = persons
					.stream()
					.collect(Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.toCollection(TreeSet::new))));
			
			System.out.println("map4 = " + map4);
			
			
			
			//==================================================================
			//Collectors ex5
			//Numele persoanelor grupate dupa varsta speparate prin virgula si returnate intr-un String
			//Folosim DOWNSTREAM COLLECTORS
			//==================================================================
			
			Map<Integer, String> map5 = persons
					.stream()
					//Al 2-lea argument din groupingBy este un Collector care este folosit pt a procesa valorile din Map. Daca nu am furniza acest Collector, valorile din map
					//vor fi liste de persoane care au varsta din cheia pe care o au in map. Daca furnizam insa acest Collector putem face ca in loc de lista de persoane sa avem in 
					//valoarea corespunzatoare cheii o lista de nume ale persoanelor respective ordonate alfabetic sau un String in care sunt concatenate numele persoanelor cu acea
					//varsta sau orice alte date obtinute si prelucrate din persoanele din lista initiala pe care ar fi asignat-o in mod normal la cheia respectiva.
					//**Datele cum ar fi numele sau alte chestii din obiectele Person sunt obtinut
					.collect(Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.joining(", "))));
			
			System.out.println("map5" + map5);
			
			
			
			
			
		}catch(IOException ex){
			System.out.println(ex);
		}

	}

}
