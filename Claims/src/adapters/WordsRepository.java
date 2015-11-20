package adapters;

import java.util.ArrayList;
import java.util.Random;

public class WordsRepository {

	private ArrayList<String> words=new ArrayList<String>();
	private Random random=new Random();
	
	public WordsRepository() {
		add("Word1");
		add("Word2");
		add("Word3");
		add("Word4");
		add("Word5");
		add("Word6");
	}
	
	
	public void add(String word) {
		words.add(word);
	}
	
	public ArrayList<String> retrieveRandom(int count) {
		ArrayList<String> randomWords=new ArrayList<String>();
		while (randomWords.size()<count) {
			String randomWord=generateOneRandomWord();
			if (!randomWords.contains(randomWord)) {
				randomWords.add(randomWord);
			}
		}
		return randomWords;
	}

	private String generateOneRandomWord() {
		int countWords=words.size();
		int maxRandomNumber=countWords-1;
		int randomIndex=random.nextInt(maxRandomNumber);
		String randomWord=words.get(randomIndex);
		return randomWord;
	}
}
