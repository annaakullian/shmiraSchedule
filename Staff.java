//
// Staff.java
// This class defines a Staff object for ShmiraCoder.java
//
// Written by Aaron Morrill
// Began Writing 7/16/19
//

import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Staff {

	String name;
	ArrayList<String> badDates = new ArrayList<String>();
	ArrayList<Integer> badDatesInt = new ArrayList<Integer>();
	int firstNight, secondNight;

	public Staff(String s) {

		Scanner scanner2 = new Scanner(s);

		name = scanner2.next();

		while (scanner2.hasNext()) {

			badDates.add(scanner2.next());

		} // end of while loop

		firstNight = -1;
		secondNight = -1;

	} // end of first constructor

	public Staff(int i) {

		name = "filler";

	} // end of second constructor

} // end of main class