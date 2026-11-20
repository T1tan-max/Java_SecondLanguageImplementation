import java.util.HashMap;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter text to analyze:");
        String text = input.nextLine();

        System.out.println("\nText Analysis Results");

        System.out.println("Character count: " + countCharacters(text));
        System.out.println("Word count: " + wordCount(text));
        System.out.println("Line count: " + countLines(text));
        printFrequency(text);
        System.out.println("Sentence count: " + countSentences(text));
        System.out.println("Average word length: " + averageWordLength(text));



        input.close();
    }

    public static int countCharacters(String text){
        return text.length();
    }
    public static int wordCount(String text){
        String[] words = text.trim().split("\\s+");

        if (text.trim().isEmpty()){
            return 0;
        }
        return words.length;
    }
    public static int countLines(String text){
        if (text.isEmpty()){
            return 0;
        }
        return text.split("\n", -1).length;
    }
    public static HashMap<String, Integer> countFrequency(String text){
        HashMap<String, Integer> frequency = new HashMap<>();

        String[] words = text.split("\\s+");

        for (String word : words){
            if (!word.isEmpty()){
                frequency.put(word, frequency.getOrDefault(word, 0) + 1);
            }
        }
        return frequency;
    }
    public static void printFrequency(String text){
        HashMap<String, Integer> frequency = countFrequency(text);

        System.out.println("Word frequency:");

        for (String word : frequency.keySet()){
            System.err.println(word + " => " + frequency.get(word) + " time(s)");
        }
    }
    public static int countSentences(String text){
        String[] sentences = text.split("[.!?]+");

        int count = 0;

        for (String sentence : sentences){
            if (!sentence.trim().isEmpty()){
                count++;
            }
        }
        return count;
    }
    public static double averageWordLength(String text){
        String[] words = text.trim().split("\\s+");

        if (text.trim().isEmpty()){
            return 0;
        }
        int totalLength = 0;

        for(String word : words){
            totalLength += word.length();
        }
        return (double) totalLength / words.length;
    }
}