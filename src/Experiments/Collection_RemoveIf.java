package Experiments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class Collection_RemoveIf {

	public static void main(String[] args) {
		
		//###***### Versiune nefunctionala
		//Da eroare deoarece colectia nu este modificabila
		//Exception in thread "main" java.lang.UnsupportedOperationException
//		Collection<String> names = Arrays.asList("Marius", "Andreea", "Maria", "David");
//		names.removeIf(name -> name.length() > 5);
//		
//		System.out.println(names.stream().collect(Collectors.joining(", ")));
				

		//*** Varianta functionala:
		//Merge deoarece colectia este modificabila si se pot face stergerile necesare
		
		Collection<String> names2 = Arrays.asList("Marius", "Andreea", "Maria", "David");
		Collection<String> list2 = new ArrayList(names2); 
		list2.removeIf(name -> name.length() > 5);
		
		System.out.println(list2.stream().collect(Collectors.joining(", ")));
		
	}

}
