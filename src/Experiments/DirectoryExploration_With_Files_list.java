package Experiments;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DirectoryExploration_With_Files_list {

	public static void main(String[] args) {
		Path path = Paths.get("d:", "Work", "Java Workspace Training", "Java_8_PS_What_is_new");//, "Products.txt");
		try(Stream<Path> streamDir = Files.list(path)){
			streamDir.forEach(System.out::println);
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}

}
