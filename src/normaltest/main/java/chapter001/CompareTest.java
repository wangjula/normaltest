package normaltest.main.java.chapter001;

import java.util.Arrays;
import java.util.Comparator;

public class CompareTest {

	public static void main(String[] args) {
		Generator<Integer> gen = new IntegerGenerator(100);
		Person[] people = new Person[10];
		for (int i = 0; i < people.length; i ++) {
			Person p = new Person();
			p.setAge(gen.next());
			p.setSalary(10000 + 100*gen.next());
			people[i] = p;
		}
		Arrays.sort(people);
		System.out.println(Arrays.toString(people));
		Arrays.sort(people, new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {
				if (p1.getSalary() >= p2.getSalary()) {
					return 1;
				}
				return -1;
			}
		});
		System.out.println(Arrays.toString(people));
	}

}
