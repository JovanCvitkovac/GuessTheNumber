package paket;

import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame {

	 Scanner scanner = new Scanner(System.in);
	 Random random = new Random();
	 int targetNumber = generateRandomTargetNumber();
	 String userInputAsString;
	 String targetNumberAsString = String.valueOf(targetNumber);
	 char targetNumberChar1 = targetNumberAsString.charAt(0);
	 char targetNumberChar2 = targetNumberAsString.charAt(1);
	 char charInput1 = 0;
	 char charInput2 = 0;
	 int input = 0;
	 String msg = "";



	public void run() {
		userInputAsString = scanner.nextLine();

		while (true) {
			startUp();
			validate();
			output();
			userInputAsString = scanner.nextLine();
			if (input == targetNumber) {
				return;
			}

		}
	}

	public void startUp() {
		if (targetNumberChar1 == targetNumberChar2) {
			targetNumberChar2++;
		}
	}
	
	public void validate() {
		checkUserInput();
		extractChars();
	}
	
	public void checkUserInput() {
		try {
			input = Integer.parseInt(userInputAsString);
		} catch (NumberFormatException e) {
			msg = e.getMessage();
			displayMsg();
		}
	}
	
	private void extractChars() {
		try {
			charInput1 = userInputAsString.charAt(0);
			charInput2 = userInputAsString.charAt(1);
		} catch (StringIndexOutOfBoundsException e) {
			msg = e.getMessage();
			displayMsg();
		}
	}

	// https://www.baeldung.com/java-generating-random-numbers
	private int generateRandomTargetNumber() {
		return random.nextInt(99 - 10) + 10;
	}

	public void output() {

		if (input == targetNumber) {
			msg = "Correct guess, well done!";
			displayMsg();
			return;
		} else if (input > 99) {
			msg = "Input value has to be numbers 10-99";
		} else if (input < 10) {
			msg = "Input value has to be numbers 10-99";
		} else if (targetNumberChar1 == charInput1 || targetNumberChar2 == charInput2) {
			msg = "1 digit in Right place, 0 digits in Wrong place";
		} else if (targetNumberChar1 == charInput2 && targetNumberChar2 == charInput1) {
			msg = "0 digits in Right place, 2 digits in Wrong place";
		} else if (targetNumberChar1 == charInput2 || targetNumberChar2 == charInput1) {
			msg = "0 digits in Right place, 1 digit in Wrong place";
		} else {
			msg = "There are no such digits in our number, try again";
		}
		displayMsg();
	}
	
	private void displayMsg(){
		System.out.println(msg);
	}
	
	

}
