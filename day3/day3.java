import java.io.*;
import java.util.*;

class Day3 {
	public static void main(String[] args) {		
		
		int sum = 0;
		Set<Character> set = new HashSet<>();
		Set<Character> set2 = new HashSet<>();
		
		try {
			File myObj = new File("input.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
//				String s1 = data.substring(0, data.length()/2);
//				String s2 = data.substring(data.length()/2);
				
				System.out.println(data);
				
				for(char ch : data.toCharArray()) {
					set.add(ch);
				}
				
				
				data = myReader.nextLine();
				System.out.println(data);
				
				for(char ch : data.toCharArray()) {
					if(set.contains(ch)) {
						set2.add(ch);
					}
				}
				
				data = myReader.nextLine();
				
				System.out.println(data);
				for(char ch : data.toCharArray()) {
					if(set2.contains(ch)) {
						if(Character.isUpperCase(ch)) {
//							System.out.println(ch + " " + (ch - 'A' + 27));
							sum+=ch-'A'+27;
						} else if(Character.isLowerCase(ch)) {
//							System.out.println(ch + " " + (ch - 'a' + 1));
							sum+=ch-'a'+1;
						}
						
						break;
					}
				}
				
				
				set.clear();
				set2.clear();
				
//				System.out.println(sum);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		System.out.println(sum);
	}
}