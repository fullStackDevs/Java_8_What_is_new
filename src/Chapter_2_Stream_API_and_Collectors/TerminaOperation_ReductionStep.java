package Chapter_2_Stream_API_and_Collectors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TerminaOperation_ReductionStep {

	public static void main(String[] args) {
		Person p1 = new Person("Popescu Ion", 34);
		Person p2 = new Person("Dumitrescu Vasile", 24);
		Person p3 = new Person("Bulgarasu Adina", 21);
		List<Person> persons = Arrays.asList(p1, p2, p3);
		
		boolean allLongNames = persons.stream()
				.map(person -> person.getName())
				.allMatch(name -> name.length() > 20);

		System.out.println("All the names from the stream are longer than 20 caracters: " + allLongNames);
		
		//=======================================================
		
		List<Person> list2 = new ArrayList<>();
		
		persons.stream()
			.peek(System.out::println)
			.filter(person -> person.getAge() < 24)
			.forEach(list2::add);
		
		System.out.println("list2 size = " + list2.size());
		
		TerminaOperation_ReductionStep tor = new TerminaOperation_ReductionStep();
		
	}
	
	public void testMethodReference(List<Person> persons){
		persons.stream()
			.map(Person::getAge)
			.filter(age -> age > 20)
			.forEach(System.out::println);
	}

}
