package passwordStrengthChecker;

import java.util.Scanner;
import java.util.regex.Pattern;
/*
 * This class checks the security of a user input password. 
 * It judges the password on length, contents, consecutive characters, and common passwords.
 * It then gives the password a rating from 0 to 10.
 */
public class passwordChecker {
	// highest possible score is 10

	public static void main(String[] args) {

		try (Scanner input = new Scanner(System.in)) {
			System.out.println("Enter password: ");
			String password = input.nextLine();

			if (password.length() < 1 || password == null) {
				System.out.println("Please enter a valid password. ");

			} else {
				int score = findPassScore(password);
				System.out.println("The score of this password is " + score + ". ");
			}
		}
	
	}

	public static int findPassScore(String password) {

		int totalScore = 0;

		totalScore = totalScore + length(password) + contents(password) + birthday(password) + consecutive(password)
				+ commonWords(password);

		switch (totalScore) {

		case 1:
			System.out.println("This is a weak password.");
			break;
		case 2:
			System.out.println("This is a weak password.");
			break;
		case 3:
			System.out.println("This is a somewhat weak password.");
			break;
		case 4:
			System.out.println("This is a somewhat weak password.");
			break;
		case 5:
			System.out.println("This is a somewhat strong password.");
			break;
		case 6:
			System.out.println("This is a somewhat strong password.");
			break;
		case 7:
			System.out.println("This is a somewhat strong password.");
			break;
		case 8:
			System.out.println("This is an almost strong password.");
			break;
		case 9:
			System.out.println("This is an almost strong password.");
			break;
		case 10:
			System.out.println("Horray!! You have found a strong password.");
			break;

		}

		return totalScore;

	}

	private static int length(String password) {

		int lengthScore = 0;
		int length = password.length();

		if (length >= 16) {
			lengthScore = 2;
		} else if (length >= 12) {
			lengthScore = 1;
		} else {
			lengthScore = 0;
		}
		System.out.println("Length Score: " + lengthScore + ". ");

		return lengthScore;
	}

	private static int contents(String password) {

		int contentsScore = 0;

		boolean uppercase = false;
		boolean lowercase = false;
		boolean number = false;
		boolean special = false;

		for (int i = 0; i < password.length(); i++) {

			char c = password.charAt(i);

			if (Character.isUpperCase(c)) {

				uppercase = true;

			} else if (Character.isLowerCase(c)) {

				lowercase = true;

			} else if (Character.isDigit(c)) {

				number = true;
				
			} else {
				special = true;
			}
		}

		if (uppercase)
			contentsScore += 1;

		if (lowercase)
			contentsScore += 1;

		if (number)
			contentsScore += 1;

		if (special)
			contentsScore += 1;

		System.out.println("Contents Score: " + contentsScore + ". ");

		return contentsScore;
	}

	private static int birthday(String password) {

		int birthdayScore = 0;

		boolean birthdayMatch = Pattern.compile("^[0-9]{1,2}\\/[0-9]{1,2}\\/[0-9]{4}$").matcher(password).find();

		if (birthdayMatch == false) {
			birthdayScore = 1;
		}

		System.out.println("Birthday Score: " + birthdayScore + ". ");

		return birthdayScore;
	}

	private static int consecutive(String password) {
		int consecutiveScore = 0;
		boolean checkcons = false;

		if (password != null && password.length() > 1) {

			for (int i = 0; i < password.length() - 1; i++) {
				if (password.charAt(i) == password.charAt(i + 1)) {
					checkcons = true;
				}
			}
		}

		if (checkcons == false)
			consecutiveScore = 1;
		System.out.println("Consecutive Score: " + consecutiveScore + ". ");

		return consecutiveScore;

	}

	private static int commonWords(String password) {

		int commonWordsScore = 0;

		if (password.contains("hello") || password.contains("password") || password.contains("secret")
				|| password.contains("qwerty")) {
			commonWordsScore = -1;
		} else {
			commonWordsScore = 2;
		}

		System.out.println("Common Words Score: " + commonWordsScore + ". ");

		return commonWordsScore;
	}
}
