package Chapter_3_Date_And_Time;

import java.time.LocalDate;

public class PersonD {
	
	private String name;
	private LocalDate dateOfBirth;
	
	public PersonD(){}
	
	public PersonD(String name, LocalDate birthDate){
		this.name = name;
		this.dateOfBirth = birthDate;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthDate() {
		return dateOfBirth;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.dateOfBirth = birthDate;
	}
	
	public String toString(){
		return "Person{name = " + name + ", dateOfBirth = " + dateOfBirth + "}"; 
	}
	

}
