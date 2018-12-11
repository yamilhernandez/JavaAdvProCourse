package Exam3.SortAPI;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;

public class SortAPITest {
	
	SortAPI.Student s1;
	SortAPI.Student s2;
	SortAPI.Student s3;
	SortAPI.Student s4;
	SortAPI.Student s5;
	SortAPI.Student s6;
	SortAPI.Student s7;
	SortAPI.Student s8;
	SortAPI.Student s9;
	SortAPI.Student s10;
	
	SortAPI.Student[] original;
	SortAPI.Student[] reversed;
	SortAPI.Student[] alternate1;
	SortAPI.Student[] alternate2;
	SortAPI.Student[] sortedByID;
	SortAPI.Student[] sortedByGenderThenLastName;
	SortAPI.Student[] sortedByHeightThenAge;
	SortAPI.Student[] sortedByGenderThenAge;
	
	@Before
	public void setup() {
		s1 = new SortAPI.Student(1, "Maria", "Rivera", "F", 18, 64);
		s2 = new SortAPI.Student(2, "Ana", "Rodriguez", "F", 17, 67);
		s3 = new SortAPI.Student(3, "Carmen", "Collazo", "F", 24, 63);
		s4 = new SortAPI.Student(4, "Melissa", "Perez", "F", 19, 62);
		s5 = new SortAPI.Student(5, "Rosa", "Riveras", "F", 16, 61);
		
		s6 = new SortAPI.Student(6, "Juan", "Rivera", "M", 23, 70);
		s7 = new SortAPI.Student(7, "Miguel", "Rodriguez", "M", 22, 69);
		s8 = new SortAPI.Student(8, "Pedro", "Collazo", "M", 20, 68);
		s9 = new SortAPI.Student(9, "Carlos", "Perez", "M", 25, 66);
		s10 = new SortAPI.Student(10, "Manuel", "Riveras", "M", 21, 65);
		
		original = new SortAPI.Student[]{s1, s2, s3, s4, s5, s6, s7, s8, s9, s10};
		reversed = new SortAPI.Student[]{s10, s9, s8, s7, s6, s5, s4, s3, s2, s1};
		alternate1 = new SortAPI.Student[]{s1, s6, s2, s7, s3, s8, s4, s9, s5, s10};
		alternate2 = new SortAPI.Student[]{s6, s1, s7, s2, s8, s3, s9, s4, s10, s5};
		sortedByID = new SortAPI.Student[]{s1, s2, s3, s4, s5, s6, s7, s8, s9, s10};
		sortedByGenderThenLastName = new SortAPI.Student[]{s3, s4, s1, s5, s2, s8, s9, s6, s10, s7};
		sortedByHeightThenAge = new SortAPI.Student[]{s5, s4, s3, s1, s10, s9, s2, s8, s7, s6};
		sortedByGenderThenAge = new SortAPI.Student[]{s5, s4, s3, s1, s2, s10, s9, s8, s7, s6};
		
	}

	@Test
	public void testSortByIdSorted() {
		assertTrue(Arrays.equals(sortedByID, SortAPI.sortById(original)));
		assertTrue(Arrays.equals(sortedByID, SortAPI.sortById(alternate1)));
	}
	
	@Test
	public void testSortByIdReversed() {
		assertTrue(Arrays.equals(sortedByID, SortAPI.sortById(reversed)));
	}

	@Test
	public void testSortByIdOthers() {
		assertTrue(Arrays.equals(sortedByID, SortAPI.sortById(alternate1)));
		assertTrue(Arrays.equals(sortedByID, SortAPI.sortById(alternate2)));
		assertTrue(Arrays.equals(sortedByID, SortAPI.sortById(sortedByGenderThenLastName)));
	}
	
	@Test
	public void testSortByGenderLastNameSorted() {
		assertTrue(Arrays.equals(sortedByGenderThenLastName, SortAPI.sortByGenderLastName1(sortedByGenderThenLastName)));
	}
	
	@Test
	public void testSortByGenderLastNameReversed() {
		assertTrue(Arrays.equals(sortedByGenderThenLastName, SortAPI.sortByGenderLastName1(reversed)));
	}

	@Test
	public void testSortByGenderLastNameOthers() {
		assertTrue(Arrays.equals(sortedByGenderThenLastName, SortAPI.sortByGenderLastName1(original)));
		assertTrue(Arrays.equals(sortedByGenderThenLastName, SortAPI.sortByGenderLastName1(alternate1)));
		assertTrue(Arrays.equals(sortedByGenderThenLastName, SortAPI.sortByGenderLastName1(alternate2)));
	}
}