package Chapter_2_Stream_API_and_Collectors;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class EX_1_Filters_and_Predicates {

	public static void main(String[] args) {
		
		Stream<String> numbers = Stream.of("one", "two", "three", "four", "five");
		
		Predicate<String> p1 = strNr -> strNr.length() > 3;
		//Predicate<String> p2 = strNr -> strNr.equals("two"); 
		Predicate<String> p2 = Predicate.isEqual("two");
		Predicate<String> p3 = Predicate.isEqual("three");
		
		numbers
			.filter(p2.or(p3))
			.forEach(nr -> System.out.println(nr));
		
	}

}
