package eg.edu.alexu.csd.datastructure.hangman.cs84;

import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game implements IHangman{
    String[] lines = new String[1023];
    int c1=0;
    String filename = "C:\\dictionary.txt";
    String com;
    String expect;
    Integer maximum;
    int count=0;
    int length=0;
    char[] guessArr = new char[100];
    char[] str = new char[100];
    String low;
    
    /*function to read file and store words in array*/
    public String[] FileRead()
    {
		String[] arr = new String[1023];
		try {
        FileReader fileReader = new FileReader(filename);
         
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
         
        while ((line = bufferedReader.readLine()) != null) 
        {
            arr[c1]=line;
        	c1++;
        }
         
        bufferedReader.close();
		}
		catch(IOException e){
			System.out.println("Unable to create "+filename+": "+e.getMessage());
		}
        return arr;
    } 
    
    /*function to set the words as dictionary*/
	public void setDictionary(String[] words) {
		words = FileRead();
		for(int i=0; i<c1; i++) {
			lines[i] = words[i];
		}
	}

	/*function to get a random word*/
	public String selectRandomSecretWord() {
		Random r = new Random();
		int randomNumber = r.nextInt(c1);
		com = lines[randomNumber];
		low = com.toLowerCase();
		length = com.length();
		str = low.toCharArray();
		for (int i = 0; i < length; i++) { 
            guessArr[i] = '-';
        }
		return com;
	}
	
	/*function to check the input from user*/
	public String guess(Character c) throws Exception{
		int found = 0;
		if(com.matches("[a-zA-Z]*$")) {
		if(Character.isLetter(c)) {
			for(int i=0;i<length;i++) {
				if(Character.toLowerCase(c)==str[i]) {
					found++;
					count++;
					guessArr[i]=str[i];
				}
			}
		}
		else {
			System.out.println("not Character");
			found++;
		}
		if(found==0) {
			maximum--;
		}
		if(maximum==0) {
			throw new Exception("You Lost!");
		}
		 expect = String.copyValueOf(guessArr);
		return expect;
		}
		else {
			throw new Exception("Buggy Word");
		}
	}
	
	/*available number of wrong guesses*/
	public void setMaxWrongGuesses(Integer max) {
		if(max==null || max<=0) {
			max=1;
		}
		maximum = max;
	}
	
}
