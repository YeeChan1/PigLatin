// A program that translates words into simple pig latin 

import java.util.Scanner;

public class PigLatin {
	
	private String userText;
	private String pigText;
	
	private String[] consonants = {"b","c","d","f","g","h","j",
			"k","l","m","n","p","q","r","s","t","v","w","x","z","B","C","D",
			"F","G","H","J","K","L","M","N","P","Q","R","S","T","V","W","X","Z"};
	private String[] vowels = {"a","e","i","o","u","A","E","I","O","U"};	
	
	/*Checks if word starts with consonant*/
	public boolean startsWithConsonant(){
		
		boolean startsConsonant = false;
		
		/*Iterate through all the consonants to check if the first letter is one of them*/
		for(String a: consonants){
			if(userText.startsWith(a)){
				for(String b: consonants){
					if(!userText.substring(1).startsWith(b)){
						startsConsonant = true;
					}
				}
			}
		}
		return startsConsonant;
	}
	
	//Checks if word starts with consonant cluster
	public boolean startsWithBlend(){
		
		boolean blend = false;
		
		for(String c: consonants){
			if(userText.startsWith(c)){
				for(String d: consonants){
					if(userText.substring(1).startsWith(d)){
						blend = true;
					}
				}
			}
		}
		
		return blend;
	}
	
	//Checks if word starts with vowel
	public boolean startsWithVowel(){
		
		boolean startVowel = false;
		
		for(String e: vowels){
			if(userText.startsWith(e)){
				startVowel = true;
			}
		}
		
		return startVowel;
		
	}
	
	//Checks if word starts with the letter y
	public boolean startsWithY(){
		
		boolean startsY = false;
		
		if(userText.startsWith("y") || userText.startsWith("Y")){
			startsY = true;
		}
		
		return startsY;
	}
	
	//This method translates the word
	public String makePig(){
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Please enter a word");
		
		userText = keyboard.nextLine();
		
		keyboard.close();
		
		// Make sure it is one word
		if(userText.contains(" ")){
			System.out.println("This is not one word");
			pigText = "???";
		}
		
		/* If word starts with two consonants then
		 * return word from 3rd letter on with first two letters and
		 * ay attached to the end of it. This also applies to y rule as y
		 * becomes a vowel in this case */
		else if(startsWithBlend() == true){
			String firstTwoLetters = userText.substring(0, 2);
			pigText = userText.substring(2) + firstTwoLetters + "ay";
		}
			
		/* If word starts with a consonant then
		 * return word from 2nd letter on with first letter and 
		 * ay attached to the end of it */
		else if(startsWithConsonant() == true || startsWithY() == true){
			String firstLetter = Character.toString(userText.charAt(0));
			pigText = userText.substring(1) + firstLetter + "ay";
		}
			
		/* If word starts with a vowel then
		 * add way to the end of it */
		else if(startsWithVowel() == true){
			pigText = userText + "way";
		}
		
		System.out.println(userText + " in Pig Latin is: " + pigText);
		
		return pigText;
	}
	
	public static void main(String[] args) {
		PigLatin pig = new PigLatin();
		pig.makePig();
	}
	
}
