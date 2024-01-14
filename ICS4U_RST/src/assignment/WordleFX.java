package assignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;

public class WordleFX {

	public static void wordClean(String wordleGuess, Square[][] userBoard, int numCol, int numGuesses) {
		if (checkWord(wordleGuess, userBoard, numCol, numGuesses)) {
		} else {
			// Get all the unique characters of the guess
			ArrayList<Character> uniqueChar = uniqueCharacters(wordleGuess);
			
			// Processing 
			for (int i = 0; i < numCol; i++) {
				if (userBoard[numGuesses - 1][i].getValue() != Square.GREEN) {
					for (int j = 0; j < uniqueChar.size(); j++) {
						if (wordleGuess.charAt(i) == uniqueChar.get(j)) {
							userBoard[numGuesses - 1][i].setYellow(); 
						} else {
							userBoard[numGuesses - 1][i].setGray();
						}
					}
				}
			}
		}
	}

	public static boolean checkWord(String wordleGuess, Square[][] userBoard, int numCol, int numGuesses) {
		// Processing
		String keyWord = "";
		String line;
		int randNum;
		int counter = 0;
		ArrayList<String> allWordleWords = new ArrayList<String>();

		// Processing
		try {
			FileReader wordFile = new FileReader("data/wordleWords");
			BufferedReader fileReader = new BufferedReader(wordFile);

			while ((line = fileReader.readLine()) != null) {
				allWordleWords.add(line);
			}
			fileReader.close();

			// Error Checking
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException a) {
			a.printStackTrace();
		}
		// Processing
		randNum = randomNumber(0, allWordleWords.size() - 1);
		keyWord = allWordleWords.get(randNum);

		for (int i = 0; i < numCol; i++) {
			if (wordleGuess.charAt(i) == keyWord.charAt(i)) {
				counter += 1; 
				userBoard[numCol][numGuesses].setGreen();
			}
		}

		// Processing
		if (counter == 5) {
			return true;
		} else {
			return false;
		}
	}
	
	public static ArrayList<Character> uniqueCharacters(String wordleGuess) {
		// Variables 
		ArrayList<Character> uniqueChars = new ArrayList<Character>();
		
		// Processing 
		for (int i = 0; i < wordleGuess.length(); i++) {
			char currentChar = wordleGuess.charAt(i); 
			
			// Check if the character is not in the uniqueChars list 
			if (!uniqueChars.contains(currentChar)) {
				uniqueChars.add(currentChar);
			}
		}
		return uniqueChars; 
	}
	
	public static void clearBoard(int numCol, int numRow, Square[][] userBoard) {
		for (int i = 0; i < numRow; i++) {
			for (int j = 0; j < numCol; j++) {
				userBoard[i][j].clear();
			}
		}
	}
	
	
	/**
	 * Generates a random integer between two specified values, inclusive.
	 *
	 * @param a The lower bound of the range.
	 * @param b The upper bound of the range.
	 * @return A random integer within the specified range.
	 */
	public static int randomNumber(int a, int b) {
		int highNum = Math.max(a, b);
		int lowNum = Math.min(a, b);
		int range = highNum - lowNum + 1;
		return (int) (Math.random() * range) + lowNum;
	}
}