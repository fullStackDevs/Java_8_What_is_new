package Experiments;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DirecotryExploration_With_Files_walk {

	public static void main(String[] args) {
		Path path = Paths.get("d:", "Work", "Java Workspace Training", "Java_8_PS_What_is_new");
		try(Stream<Path> streamPaths = Files.walk(path,2)){
			streamPaths.forEach(System.out::println);
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}

}
