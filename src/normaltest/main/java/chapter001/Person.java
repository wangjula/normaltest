package normaltest.main.java.chapter001;

public class Person implements Comparable<Person> {

	private int age;
	
	private double salary;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "age: " + age + "salary: " + salary;
	}

	@Override
	public int compareTo(Person o) {
		if (this.age > o.getAge()) {
			return 1;
		} else if (this.age < o.getAge()) {
			return -1;
		} else {
			return 0;
		}
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}
