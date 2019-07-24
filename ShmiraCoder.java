//
// ShmiraCoder.java
// This class schedules Shmira assignments for general Tawonga staff
//
// Written by Aaron Morrill
// Began Writing 7/16/19
//

import java.util.Scanner;
import java.util.*;
import java.io.*;

public class ShmiraCoder {

	File f;
	Scanner scanner;
	boolean assigned;
	Staff currentStaff, filler;
	int currentInt;
	
	List<Staff> staff = new ArrayList<Staff>();
	List<Date> dates = new ArrayList<Date>();
	int firstDate = 801;

	public ShmiraCoder() {

		filler = new Staff(-1);

		for (int i=0; i < 12; i++) {

			Date date = new Date(firstDate);

			dates.add(date);

			firstDate++;

		} // end of for loop

		for (int i=0; i < dates.size(); i++) {

			dates.get(i).shmira.add(filler);

		} // end of for loop

		assigned = false;
		currentInt = -1;

	} // end of constructor

	public void scanFile(String staffInfo) {

    	try {

        	f = new File(staffInfo);

        	if (!f.exists()) {

        		throw new FileNotFoundException();

        	} else {

        		scanner = new Scanner(f);

        		if (!f.exists()) {

        			throw new FileNotFoundException();

        		} else {

        			Staff person;

        			while (scanner.hasNextLine()) {

        				person = new Staff(scanner.nextLine());

        				staff.add(person);

        			} // end of while loop

        		}

        	}

    	} // end try

    	catch (FileNotFoundException e) {

    		System.out.println("");
    		System.out.println("There was a problem in scanning the text file");
    		System.out.println("");

    		System.exit(0);

    	} // end catch

	} // end of scanFile method

	public void scheduleShmira() {

		while (!fullSchedule()) {

			for (int k=0; k < staff.size(); k++) {

				currentStaff = staff.get(k);

				assigned = false;

				while (assigned == false) {

					for (int i=0; i < dates.size(); i++) {

						for (int j=0; j < 9; j++) {

							if (dates.get(i).shmira.size() < 9 
								&& !currentStaff.badDatesInt.contains(dates.get(i).day) 
								&& (currentStaff.firstNight == -1 || currentStaff.secondNight == -1)) {

								dates.get(i).shmira.add(currentStaff);

								if (currentStaff.firstNight == -1) {

									currentStaff.firstNight = dates.get(i).day;

								} else {

									currentStaff.secondNight = dates.get(i).day;

								}

								assigned = true;

							}
				
						} // end of j for loop

					} // end of i for loop

				} // end of inner while loop

			} // end of k for loop

		} // end of outer while loop

	} // end of scheduleShmira method

	private boolean fullSchedule() {

		boolean answer = true;

		for (int i=0; i < 12; i++) {

			if (dates.get(i).shmira.size() != 9) {

				answer = false;

			}

		} // end of for loop

		return answer;

	} // end of private helper fullSchedule method

	public void integerBadDates(List<Staff> staffList) {

		for (int i=0; i < staffList.size(); i++) {

			for (int j=0; j < staffList.get(i).badDates.size(); j++) {

				currentInt = Integer.parseInt(staffList.get(i).badDates.get(j));
				staffList.get(i).badDatesInt.add(currentInt);

			} // end of inner for loop

		} // end of outer for loop

	} // end of private helper staffList method

} // end of main class