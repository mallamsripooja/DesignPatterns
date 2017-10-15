import java.util.HashMap;

//---------------------------------------------------------------------------------//
// Person class represents a Person and related attributes
// It also implements Cloneable interface to allow Object.clone() to be used
abstract class Person implements Cloneable
{
	private String pid;
	protected String personType;

	abstract void sampleMethod();

	// Setters
	public void setId(String pid){
		this.pid=pid;
	}

	// Getters
	public String getId(){
		return pid;
	}
	public String getPersonType(){
		return personType;
	}

	public Object clone(){
		Object clone = null;
		
		try{
			clone = super.clone();
		}
		catch(CloneNotSupportedException e){
			e.printStackTrace();
		}

		return clone;
	}

}

//---------------------------------------------------------------------------------//
// Student class (IS-A Person)
class Student extends Person
{
	public Student(){
		personType = "Student";
	}

	@Override
	public void sampleMethod(){
		System.out.println("Sample method of STUDENT class is called.");
	}
}

//---------------------------------------------------------------------------------//
// Employee class (IS-A Person)
class Employee extends Person
{
	public Employee(){
		personType = "Employee";
	}

	@Override
	public void sampleMethod(){
		System.out.println("Sample method of EMPLOYEE class is called.");
	}
}

//---------------------------------------------------------------------------------//
// Doctor class (IS-A Person)
class Doctor extends Person
{
	public Doctor(){
		personType = "Doctor";
	}

	@Override
	public void sampleMethod(){
		System.out.println("Sample method of DOCTOR class is called.");
	}
}

//---------------------------------------------------------------------------------//
// Cache Person's data
class PersonCache
{
	private static HashMap<String, Person> personMap = new HashMap<String, Person>();

	public static Person getPersonData(String pid){
		Person person = personMap.get(pid);
		return (Person) person.clone();
	}

	// DB operations can be run here to fetch data from DB and to initialize data
	public static void loadCache(){
		Student student =  new Student();
		student.setId("101");
		personMap.put(student.getId(),student);

		Employee employee =  new Employee();
		employee.setId("102");
		personMap.put(employee.getId(),employee);
		
		Doctor doctor =  new Doctor();
		doctor.setId("103");
		personMap.put(doctor.getId(),doctor);
	}
}

//---------------------------------------------------------------------------------//
// Client program to make clones of cached data
public class PersonPrototype{
	public static void main(String[] args){
		PersonCache.loadCache();

		Person person1 = (Person) PersonCache.getPersonData("101");
		Person person2 = (Person) PersonCache.getPersonData("102");
		Person person3 = (Person) PersonCache.getPersonData("103");

		System.out.printf("Person1 - \nPid : %s, Person Type : %s\n\n",person1.getId(),person1.getPersonType());
		System.out.printf("Person2 - \nPid : %s, Person Type : %s\n\n",person2.getId(),person2.getPersonType());
		System.out.printf("Person3 - \nPid : %s, Person Type : %s\n\n",person3.getId(),person3.getPersonType());
	}
}