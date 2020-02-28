package eg.edu.alexu.csd.datastructure.hangman.cs84;

import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestGame {
	public static void main(String a[]) {
		Game play = new Game();
		String get = new String();
		
		/*make dictionary and get a random word from it*/
		play.setDictionary(play.lines);
		String word = play.selectRandomSecretWord();
		
		/*user enters number of wrong guesses*/
		System.out.println("Enter number of wrong Guesses: ");
		Scanner num = new Scanner(System.in);
		Integer plays = num.nextInt();
		play.setMaxWrongGuesses(plays);
		Scanner guessing = new Scanner(System.in);
		Character player;
		
		/*the game*/
		while(play.count!=play.length){
		try {
			/*user enters his guess*/
			System.out.println("Enter your character Guess: ");
			player = guessing.next().charAt(0);
			get = play.guess(player);
			System.out.println(get);
			System.out.println("Remaining Guesses= "+play.maximum);
		}catch(Exception e) {
			/*exception if buggyword or lose*/
			System.out.println(e);
			break;
		}
		}
		if(play.count==play.length) {
			System.out.println("You Won!\nRight Word is "+get);
		}
		guessing.close();
		num.close();
	}
}
