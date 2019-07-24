//
// ShmiraTest.java
// This is the test class for ShmiraCoder.java
//
// Written by Aaron Morrill
// Began Writing 7/16/19
//

public class ShmiraTest {

	public static final void main(String[] args) {

		ShmiraCoder sc = new ShmiraCoder();

		sc.scanFile("staffInfo.txt");
		sc.integerBadDates(sc.staff);
		sc.scheduleShmira();

		System.out.println("");

		for (int i=0; i < sc.dates.size(); i++) {

			System.out.println(sc.dates.get(i).day);
			
			for (int j=1; j < 8; j++) {

				System.out.println(sc.dates.get(i).shmira.get(j).name);

			} // end of j for loop

			System.out.println("");

		} // end of i for loop

	} // end of main method

} // end of main class