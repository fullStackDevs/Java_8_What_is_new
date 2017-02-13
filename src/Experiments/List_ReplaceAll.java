package Experiments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class List_ReplaceAll {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Adriana", "Ioana", "Marian", "Cristina", "Alexandra");
		
		names.replaceAll(name -> name.toUpperCase());
		
		System.out.println(names.stream().collect(Collectors.joining(", ")));

	}

}
