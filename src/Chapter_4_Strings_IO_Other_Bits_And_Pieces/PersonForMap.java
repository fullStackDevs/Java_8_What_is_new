package Chapter_4_Strings_IO_Other_Bits_And_Pieces;

public class PersonForMap {
	
	private String name;
	private int age;
	private String gender;
	
	public PersonForMap(){}
	
	public PersonForMap(String name, int age, String gender){
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "PersonForMap [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	
	

}
