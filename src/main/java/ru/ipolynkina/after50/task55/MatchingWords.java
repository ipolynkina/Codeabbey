package main.java.ru.ipolynkina.after50.task55;

import main.java.ru.ipolynkina.IOData;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class MatchingWords {
    public static void main(String[] args) {

        List<String> originalData = IOData.readOriginalString();
        String[] words = originalData.get(0).split(" ");
        List<String> allWords = new ArrayList<>();
        TreeSet<String> repeatedWords = new TreeSet<>();

        try {
            for(String word : words) {
                if(allWords.contains(word)) repeatedWords.add(word);
                else allWords.add(word);
            }
        } catch (NumberFormatException exc) {
            System.err.println("Input data is incorrect");
            exc.printStackTrace();
        }

        IOData.writeResult(new ArrayList<>(repeatedWords));
    }
}
