package Experiments;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class List_sort {

	public static void main(String[] args) {
		List<String> cars = Arrays.asList("Pontiac", "Ferrary", "Porche", "TVR");
		cars.sort(Comparator.naturalOrder());
		
		System.out.println(cars.stream()
			.collect(Collectors.joining(", ")));
	}

}
