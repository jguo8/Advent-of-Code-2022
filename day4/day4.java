import java.io.*;
import java.util.*;

class Day4 {
	public static void main(String[] args) {		
		
		int sum = 0;
//		.2345678.  2-8
//		..34567..  3-7
//		
//		.....6...  6-6
//		...456...  4-6
		
		try {
			File myObj = new File("input.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String[] intervals = data.split(",");

				String[] pair1 = intervals[0].split("-");
				String[] pair2 = intervals[1].split("-");
 				int pair1a = Integer.parseInt(pair1[0]);
				int pair1b = Integer.parseInt(pair1[1]);
				int pair2a = Integer.parseInt(pair2[0]);
				int pair2b = Integer.parseInt(pair2[1]);
				
				if(pair1a <= pair2a && pair1b >= pair2a ) {
					sum++;
				}
				else if (pair2a <= pair1a && pair2b >= pair1a) {
					sum++;
				}
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		System.out.println(sum);
	}
}