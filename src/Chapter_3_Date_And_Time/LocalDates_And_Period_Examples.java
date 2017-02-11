package Chapter_3_Date_And_Time;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import Chapter_2_Stream_API_and_Collectors.CollectorsExample;
import Chapter_2_Stream_API_and_Collectors.Person;

public class LocalDates_And_Period_Examples {

	public static void main(String[] args) {
		
		List<PersonD> persons = new ArrayList<PersonD>();
		
		try(
				BufferedReader reader = new BufferedReader(new InputStreamReader(LocalDates_And_Period_Examples.class.getResourceAsStream("personsBirthDates.txt")));
				//BufferedReader reader = new BufferedReader(new InputStreamReader(CollectorsExample.class.getResourceAsStream("persons.txt")));
				Stream<String> stream = reader.lines();
				){
			
			stream.map(
				line -> {
					String[] str = line.split(" ");
					String name = str[0].trim();
					int year = Integer.parseInt(str[1]);
					Month month = Month.of(Integer.parseInt(str[2]));
					int dayOfMonth = Integer.parseInt(str[3]);
					LocalDate birthDate = LocalDate.of(year, month, dayOfMonth);
					PersonD person = new PersonD(name, birthDate);
					persons.add(person);	
					return person;
				})
				.forEach(System.out::println);			
			
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		
		//Afisam pt fiecare persoana din stream ce perioada a trecut de cand s-au nascut pana in prezent
		//Perioada va fi afisata in 2 feluri:
		//				- folosind Period.between(...) pt a arata nr. de ani, luni zi zile de cand s-au nascut
		//				- folosind metoda "until(...)" din obiectele de tip LocalDate??
		
		LocalDate now = LocalDate.now();
		
		persons.stream()
			.forEach(person -> {
				Period elapsed = Period.between(person.getBirthDate(), now);
				System.out.print("Time passed since " + person.getName() + " was born: " + elapsed.get(ChronoUnit.YEARS) + " years ");
				System.out.print(" " + elapsed.get(ChronoUnit.MONTHS) + " months");
				System.out.print(" and " + elapsed.get(ChronoUnit.DAYS) + " days");
				//###***###
				//Trebuie sa avem grija sa nu confundam metoda "get(ChronoUnit.MONTHS)" din Period cu metoda "until(localDate, ChronoUnit.MONTHS) din LocalDate"
				//Metoda get(...) din Period returneaza numarul de luni ramase dupa ce s-au calculat numarul de ani (de exemplu daca au trecut 20 de ani si 4 luni de la nasterea
				//nunei persoane aceasta metoda va afisa "4")
				//Metoda until(...) va calcula numarul total de luni trecute de la o anumita data (pt acelasi exemplu va afisa rezultatul pt. 12 * 20 + 4)
				System.out.print(" --- (" + person.getBirthDate().until(now, ChronoUnit.MONTHS) + " months passed since this person was born)");
				System.out.println();		
		});

	}

}
