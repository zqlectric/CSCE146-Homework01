/*
 * Written by Zachary Goldberg
 */

//Packages
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

//Class Definition
public class main {
	
	//Method to read file and parse it into prizes and costs arrays
	public static void readFile(String fileName, String[] prizes, int[] costs) {
		try {
			Scanner fileScanner = new Scanner(new File(fileName));
			int i=0;
			while(fileScanner.hasNextLine()) {
				String fileLine = fileScanner.nextLine();
				String[] splitLine = fileLine.split("\t");
				if(splitLine.length == 2) {
					prizes[i] = splitLine[0];
					costs[i] = Integer.parseInt(splitLine[1]);
					i++;
				}
			}
		}
		catch(IOException e) {
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	//This method is to count how many lines are in the file to use for the size of the prizes and costs arrays.
	public static int countLinesInFile(String inputFile) {
		try {
			Scanner fileScanner = new Scanner(new File(inputFile));
			int counter = 0;
			while(fileScanner.hasNextLine()) {
				counter++;
				fileScanner.nextLine();
			}
			return counter;
		}
		catch(IOException e) {
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	//This method executes the text in the console and most of what happens during the guess of the costs.
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Welcome to the showcase show down!");
		String[] prizes = new String[countLinesInFile("prizeList.txt")];
		int[] costs = new int[countLinesInFile("prizeList.txt")];
		readFile("prizeList.txt",prizes,costs);
		boolean quit = false;
		while(!quit) {
			System.out.println("Your prizes are:");
			int rand1 = (int) (Math.random() * countLinesInFile("prizeList.txt"));
			int rand2 = (int) (Math.random() * countLinesInFile("prizeList.txt"));
			int rand3 = (int) (Math.random() * countLinesInFile("prizeList.txt"));
			int rand4 = (int) (Math.random() * countLinesInFile("prizeList.txt"));
			int rand5 = (int) (Math.random() * countLinesInFile("prizeList.txt"));
			System.out.println(prizes[rand1]);
			System.out.println(prizes[rand2]);
			System.out.println(prizes[rand3]);
			System.out.println(prizes[rand4]);
			System.out.println(prizes[rand5]);
			
			int totalCost = costs[rand1] + costs[rand2] + costs[rand3] + costs[rand4] + costs[rand5];
			
			System.out.println("You must guess the total cost of the prizes without going over and within $1,300 of its actual price");
			System.out.println("Enter your guess");
			int guess = keyboard.nextInt();
			
			//Checks if the guesses are more then the total costs.
			if(guess > totalCost) {
				System.out.println("The actual cost was " + totalCost);
				System.out.println("Your guess was over. You lose");
				System.out.println("Would you like to quit? Enter \"yes\" to quit");
				String answer = keyboard.next();
				
				if(answer.equals("yes")) { 
					quit = true; 
					System.out.println("Goodbye!"); 
				}else if(answer.equals("no")) {
					quit = false;
				}
				//Checks if the guess is within $1300 of the total cost
			}else if((totalCost - guess) >= 1300) {
				System.out.println("The actual cost was " + totalCost);
				System.out.println("Your guess was close, but not close enough. You lose.");
				System.out.println("Would you like to quit? Enter \"yes\" to quit");
				String answer = keyboard.next();
				
				if(answer.equals("yes")) { 
					quit = true; 
					System.out.println("Goodbye!"); 
				}else if(answer.equals("no")) {
					quit = false;
				}
				//Checks if the user has won
			}else {
				System.out.println("The actual cost was " + totalCost);
				System.out.println("You win!!!");
				System.out.println("Would you like to quit? Enter \"yes\" to quit");
				String answer = keyboard.next();
				
				if(answer.equals("yes")) { 
					quit = true; 
					System.out.println("Goodbye!"); 
				}else if(answer.equals("no")) {
					quit = false;
				}
			}
		}
		
	}

}
