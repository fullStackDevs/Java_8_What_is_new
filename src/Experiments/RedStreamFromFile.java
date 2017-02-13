package Experiments;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.stream.Stream;

public class RedStreamFromFile {

	public static void main(String[] args) {
		
		try(
			BufferedReader reader = 
			new BufferedReader(
			new FileReader(
			new File("D:/Work/Java Workspace Training/Java_8_PS_What_is_new/Products.txt")		
			))){
			
			Stream<String> stream = reader.lines();
			stream.map(line -> {
				String[] tokens = line.split("-");
				Product prod = new Product(tokens[0], BigDecimal.valueOf(Double.parseDouble(tokens[1].trim())));
				return prod;
				})
				.forEach(System.out::println);
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}

}
