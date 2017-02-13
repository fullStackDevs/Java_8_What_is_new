package Experiments;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReadStreamFromFileWith_Files_lines {

	public static void main(String[] args) {
		
		Path path = Paths.get("d:", "Work", "Java Workspace Training", "Java_8_PS_What_is_new", "Products.txt");
		try(Stream<String> stream = Files.lines(path)){
			stream.map(line -> {
				String[] tokens = line.split("-");
				Product prod = new Product(tokens[0].trim(), BigDecimal.valueOf(Double.parseDouble(tokens[1].trim())));
				return prod;
			})
			.forEach(System.out::println);
			
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
