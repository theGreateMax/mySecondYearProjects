import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/* Name: Lihle Mabuza
   Student Number: 4327587
   Practical 1: LongestWord.Java

   This class reads in words mixed with characters from a text file. The purpose of this class is to remove unwanted characters
   in each word and also finds the longest word in the text file and the longest word that contains the letter H.
   Then this class write the correct words along with their line number and the longest word in a txt file named Words2.txt.
 */


public class LongestWord {

    private String word;
    private int lineNum;
    private String readFilePath;


    // default constructor which takes a one parameter, the filepath
    LongestWord(String readFilePath) {
        this.readFilePath = readFilePath;

    }


    // this constructor takes in two parameters, the word and the line number of the word
    LongestWord(String word, int lineNum) {
        this.word = word;
        this.lineNum = lineNum;
    }


    private int getLineNum() {
        return lineNum;
    }


    private String getWord() {
        return word;
    }


    private String getReadFilePath() {
        return readFilePath;
    }


    //This method removes all the punctuation characters
    private String removeCharacters() {
        String str = "";

        for (int i = 0; i < getWord().length(); i++) {
            char c = getWord().charAt(i);
            if (Character.isLetter(c)) {
                str += c;
            }
        }
        return str;
    }


    // this method overrides the toString method so that we can see the actual data in the array
    public String toString() {
        return word + " " + lineNum;
    }


    //this method reads in the words from a file and store them in an array for later use
    private ArrayList<LongestWord> listOfWords() {

        File file = new File(getReadFilePath());
        Scanner scanner = null;
        LongestWord word;
        ArrayList<LongestWord> words = new ArrayList<>();
        try {
            scanner = new Scanner(file);
            int count = 0;
            while (scanner.hasNextLine()) {
                String[] arr = scanner.nextLine().split("\n");
                String str = arr[0].trim();
                count++;// keep track of the line number of the word

                //parse the words in the LongestWord class
                word = new LongestWord(str, count);

                // and remove unwanted characters using the removeCharacters function
                String finalWord = word.removeCharacters();
                int lineNum = word.getLineNum();

                // parse the words and the line number of each word in the longestWord class again
                word = new LongestWord(finalWord, lineNum);

                // add the words and the line number in an array
                words.add(word);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }

        return words;
    }


    //this method finds the longest word in the array above
    private String getLongestWord() {

        ArrayList<LongestWord> arr = listOfWords();
        int max = arr.get(0).getWord().length();
        String longestWord = "";
        int lineNum = 0;

        for (int i = 0; i < arr.size(); i++) {
            if (max < arr.get(i).getWord().length()) {
                max = arr.get(i).getWord().length();
                longestWord = arr.get(i).getWord();
                lineNum = arr.get(i).getLineNum();

            }
        }
        return "The longest word in this text file is " + "[" + lineNum + "]" + longestWord + " with " + longestWord.length() + " letters.";
    }


    //this method checks if any word in the text file contains letter h
    private boolean containLetterH(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'h' || c == 'H') {
                return true;

            }
        }
        return false;
    }

    // this method returns the longest word in the text file
    private String getLongestWithLetterH() {

        ArrayList<LongestWord> arr = listOfWords();

        ArrayList<LongestWord> newarr = new ArrayList<>();
        int max = arr.get(0).getWord().length();
        String longestWord = "";
        int lineNum = 0;


        for (LongestWord word1 : arr) {
            if (containLetterH(word1.getWord())) {

                LongestWord word2 = new LongestWord(word1.getWord(), word1.getLineNum());
                newarr.add(word2);
            }
        }

        for (int i = 0; i < newarr.size(); i++) {
            if (max < newarr.get(i).getWord().length()) {
                max = newarr.get(i).getWord().length();
                longestWord = newarr.get(i).getWord();
                lineNum = newarr.get(i).getLineNum();
            }
        }


        return "The longest word with letter H in this text file is " + "[" + lineNum + "]" + longestWord + " with " + longestWord.length() + " letters.";
    }


    //this method write the correct final words and the longest word to a text file
    public void writeTo() {

        FileWriter myWriter = null;
        ArrayList<LongestWord> arr;

        try {
            myWriter = new FileWriter("Words2.txt");
            arr = listOfWords();

            for (LongestWord i : arr) {
                myWriter.write(i.getLineNum() + " " + i.getWord() + "\n");

            }
            myWriter.write("\n" + getLongestWord());
            myWriter.write("\n" + getLongestWithLetterH());


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                myWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Done!");
    }


    public static void main(String[] args) {

        LongestWord longestWord = new LongestWord("C:\\Users\\lihle\\OneDrive\\Desktop\\Words.txt");
        longestWord.writeTo();

    }
}