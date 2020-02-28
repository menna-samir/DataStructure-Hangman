package eg.edu.alexu.csd.datastructure.hangman.cs84;

public interface IHangman {
	void setDictionary(String[] words);
	String selectRandomSecretWord();
	String guess(Character c) throws Exception;
	void setMaxWrongGuesses(Integer max);
}
