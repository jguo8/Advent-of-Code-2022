import java.io.*;
import java.util.*;

/* part 1
A = rock
B = paper
C = scissors

X = rock
Y = paper
Z = scissors
*/

class Day2 {
	public static void main(String[] args) {		
		
		/* part 2
		A = rock
		B = paper
		C = scissors
		
		X = need to lose
		Y = end with draw
		Z = need to win
		*/
		
		final Map<String,String> winnerRule = new HashMap<>(){{
			put("A", "B");
			put("B", "C");
			put("C", "A");
		}};
		//part2
		final Map<String,String> loserRule = new HashMap<>(){{
			put("A", "C");
			put("B", "A");
			put("C", "B");
		}};
//		part1
//		final Map<String,String> moveMapper = new HashMap<>(){{
//			put("A", "X");
//			put("B", "Y");
//			put("C", "Z");
//		}};
		
		final Map<String,Integer> movePts = new HashMap<>(){{
			put("A", 1);
			put("B", 2);
			put("C", 3);
		}};
		
		int sum = 0;
		
		try {
			File myObj = new File("input.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String[] playerMoves = data.split(" ");
				
				/* part 1
				if(moveMapper.get(playerMoves[0]).equals(playerMoves[1])) {
					sum+=3;
				}
				 else if(winnerRule.get(playerMoves[0]).equals(playerMoves[1])) {
					sum+=6;
				}
				*/
				String moveDealt = "X";
				
				if(playerMoves[1].equals("X")) {
					moveDealt = loserRule.get(playerMoves[0]);
				} else if(playerMoves[1].equals("Y")) {
					moveDealt = playerMoves[0];
					sum+=3;
				} else if(playerMoves[1].equals("Z")) {
					moveDealt = winnerRule.get(playerMoves[0]);
					sum+=6;
				}
				
//				System.out.println(movePts.get(playerMoves[1]));
				sum+=movePts.get(moveDealt);
				System.out.println(sum);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
//		System.out.println(sum);
	}
}