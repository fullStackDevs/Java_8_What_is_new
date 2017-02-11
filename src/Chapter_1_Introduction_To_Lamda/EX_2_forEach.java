package Chapter_1_Introduction_To_Lamda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NavigableMap;
import java.util.function.Consumer;

public class EX_2_forEach {

	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("Ana", "Diana", "Mihai", "Sorin");
		List<String> namesList2 = new ArrayList<String>();
		
		Consumer<String> c1 = name -> System.out.println(name);
		//OR we can write the above line as:
		//Consumer<String> c1 = System.out::println;
		
		Consumer<String> c2 = name -> namesList2.add(name);
		//Or we can write the above line as:
		//Consumer<String> c2 = namesList2::add;
		
		names.forEach(c1.andThen(c2));
		
		System.out.println("Size of the namesList2 array = " + namesList2.size());
		
	}

}
