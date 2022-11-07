import java.util.Scanner;

public class BuggyPigLatin {

    public static void main(String[] args) {
        System.out.println("Enter Text:"); //added system out print for enter text
        Scanner scan = new Scanner(System.in);  //added scanner to take in text
        String word = scan.nextLine(); //add scanner output  next did not take entire string, had to convert to nextLine
        String[] words = word.split(" "); // looking at word variable - splitting word based on the position of spaces in char array
        String outPut = "";   // creating an array of strings from a single string
        for(int i = 0; i < words.length; i++) {   // words(an array of words).length = iterating every word in the for loop
            if(i == 0) {
               outPut += toPigLatin(words[i]);  // the entered word plus the method
            } else {
                outPut += " " + toPigLatin(words[i]);    // runs the output only if the first is false
            }
        }
        System.out.print(outPut);
    }   public static Boolean isVowel(char c) {
            char[] vowels = {'a', 'e', 'i', 'o', 'u'};
            for (int i = 0; i < 4; i++) { // added for loop
             if(c == vowels[i]) { //if c is a vowel
               return true; //make return statement true
                }
        }
        return false; // looping array of vowels, we've looked at all vowels - the end of this for loop
    }
    public static String toPigLatin(String word) {
        //added string to function input
        char[] specialChars = {'@', '.', '-', '$', '^', '&'};
        word = word.toLowerCase();
        for (char c : specialChars) // c is a symbol that every char that exists in the array
        {
            for (char w : word.toCharArray()) // w is a symbol that every char that exists in the array

            {
                if (w == c) {
                    return word;
                }
            }
        }
        Boolean noVowels = true;
        for (char letter : word.toCharArray()) // for each loop for every character (letter)
            //that exists in the array(word) exercise underneath
        {
            if (isVowel(letter)) {
                noVowels = false;
            }
        }
        if (noVowels) {
            return word;
        }
        char firstLetter = word.toCharArray()[0];
        String output = "placeholder";
        if (isVowel(firstLetter)) {
            output = word + "way";
            return output;
        } else {
            int vowelIndex = -1; //assuming there is no vowel
            //Handle going through all the consonants

            for (int i = 0; i <= word.length(); i++) {
                if (isVowel(word.toCharArray()[i]) == true) {
                    vowelIndex = i;

                   // need to move char consonant to the end of the array, then add ay
                    break;
                }
            }
            String sub = word.substring(vowelIndex);   // deleted vowel index +1 and -1
            String postFix = word.substring(0, vowelIndex);

            output = sub + postFix + "ay";
            return output;
        }
    }
}
