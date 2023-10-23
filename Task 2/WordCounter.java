package task2;

import java.io.*;
import java.util.*;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = "";

        System.out.print("Enter a text or provide a file name: ");
        String userInput = scanner.nextLine();

        try {
            File file = new File(userInput);
            if (file.exists() && file.isFile()) {
                // Read from the file
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) {
                    text += fileScanner.nextLine() + " ";
                }
                fileScanner.close();
            } else {
                // Read from user input
                text = userInput;
            }

            String[] words = text.split("[\\s\\p{Punct}]+");
            int wordCount = words.length;

            // Ignore common words (stop words)
            List<String> stopWords = Arrays.asList("a", "an", "the", "in", "on", "at", "to", "for", "of", "and");
            words = Arrays.stream(words)
                    .filter(word -> !stopWords.contains(word.toLowerCase()))
                    .toArray(String[]::new);

            int uniqueWordCount = (int) Arrays.stream(words).distinct().count();

            System.out.println("Total word count (excluding common words): " + wordCount);
            System.out.println("Total unique word count: " + uniqueWordCount);

            // Word frequency statistics
            Map<String, Integer> wordFrequency = new HashMap<>();
            for (String word : words) {
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }

            // Display word frequency
            System.out.println("Word frequency:");
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
