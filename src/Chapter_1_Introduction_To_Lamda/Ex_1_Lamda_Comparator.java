package Chapter_1_Introduction_To_Lamda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ex_1_Lamda_Comparator {

	public static void main(String[] args) {
		
		List<String> strings = Arrays.asList("*****", "**", "*******", "****");
		
		Comparator<String> lengthComp = (str1, str2) -> Integer.compare(str1.length(), str2.length());
		
		Collections.sort(strings, lengthComp);

		strings.forEach(str -> System.out.println(str));
	}

}
