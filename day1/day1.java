import java.io.*;
import java.util.*;

class Day1 {
	public static void main(String[] args) {
		int sum = 0;
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a,b) -> a-b);
		
		try {
			File myObj = new File("input.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				
				if(data != "") {
					sum+= Integer.parseInt(data);
				} else {
					if(minHeap.size() >= 3) {
						if(sum > minHeap.peek()) {
							minHeap.poll();
							minHeap.add(sum);
						}
					} else {
						minHeap.add(sum);
					}
					
					sum = 0;
				}
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		int res = 0;
		Iterator<Integer> iter = minHeap.iterator();
		while(iter.hasNext()) {
			res+=iter.next();
		};
		
		System.out.println(res);
	}
}