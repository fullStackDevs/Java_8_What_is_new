package Experiments;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CheckOrderOfExecutionInStream {
	
	public static void printElement(String str){
		System.out.println("printElement method called with element " + str);
		//System.out.println("Element: " + str);
	}
	
	public static boolean lengthBiggerThan3(String str){
		System.out.println("lengthBiggerThan3 called with element " + str);
		return str.length() > 3;
	}
	
	public static void printMessage(String str){
		System.out.println("printMessage method called with the element " + str);
	}

	public static void main(String[] args) {
		List<String> strings = new ArrayList<String>();
		strings.add("one");
		strings.add("two");
		strings.add("three");
		strings.add("four");
		strings.add("five");
		strings.add("six");
		strings.add("seven");
		strings.add("eight");
		
		//Version 1
		Stream<String> temp = strings.stream()
				.peek(CheckOrderOfExecutionInStream::printElement)
				.filter(CheckOrderOfExecutionInStream::lengthBiggerThan3);
		
		temp.forEach(CheckOrderOfExecutionInStream::printMessage);
		
		//Version 2
//		strings.stream()
//			.peek(CheckOrderOfExecutionInStream::printElement)
//			.filter(CheckOrderOfExecutionInStream::lengthBiggerThan3)
//			.forEach(CheckOrderOfExecutionInStream::printMessage);		
		
	}
	
	

}
