package Chapter_2_Stream_API_and_Collectors;

public class Person {
	private String name;
	private Integer age;
	
	public Person(){}
	
	public Person(String name, Integer age){
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		System.out.println(name + " - getName method called");
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public String toString(){
		return "[" + name + ", " + age + "]";
	}
	
	public void testConsumerMethod(Person pers){
		System.out.println(pers.getName());
	}

}
