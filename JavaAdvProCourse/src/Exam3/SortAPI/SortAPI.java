package Exam3.SortAPI;
import java.util.Arrays;
import java.util.Comparator;

public class SortAPI {

	public static class Student {
		private int id;
		private String firstName;
		private String lastName;
		private String gender;
		private int age;
		private int height;
		
		public Student(int id, String firstName, String lastName, String gender, int age, int height) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.gender = gender;
			this.age = age;
			this.height = height;
		}
		
		public int getId() { return id; }
		public String getFirstName() { return firstName; }
		public String getLastName() { return lastName; }
		public String getGender() { return gender; }
		public int getAge() { return age; }
		public int getHeight() { return height; }

		//Implement the compareTo method from Comparable interface
		// YOUR CODE
	}

	/*
	 * Sorts list of Student's l by ID by using the 'natural' ordering
	 * of the Student class.  The 'natural' ordering is that obtained by 
	 * implementing the Comparable interface.
	 */
	public static Student[] sortById(Student[] l) {
		// YOUR CODE
		return l;
	}
	

	
	
	// Comparator class to sort students first by gender and secondly by lastname
	public static class GenderLastNameComp implements Comparator<Student> {

		@Override
		public int compare(Student arg0, Student arg1) {
			// TODO Auto-generated method stub
			return 0;
		}

		// YOUR CODE
		
	}

	/*
	 * Sorts students by gender and secondly by lastname
	 * Uses an instance of an appropriate instance of a class
	 * implementing the Comparator interface
	 */
	public static Student[] sortByGenderLastName1(Student[] l) {

		// YOUR CODE
		
		return l;
	}
}
