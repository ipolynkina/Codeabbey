package main.java.ru.ipolynkina.after10.task20;

import main.java.ru.ipolynkina.IOData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VowelCount {
    public static void main(String[] args) {

        List<String> originalData = IOData.readOriginalString();
        List<Character> vowels = Arrays.asList('a', 'o', 'u', 'i', 'e', 'y');
        List<String> results = new ArrayList<>();

        try {
            int amountTests = Integer.parseInt(originalData.get(0));
            for(int i = 1; i <= amountTests; i++) {
                Integer vowelCounter = 0;
                String word = originalData.get(i);
                for(int j = 0; j < word.length(); j++) {
                    Character ch = word.charAt(j);
                    if(vowels.contains(ch)) vowelCounter++;
                }
                results.add(vowelCounter.toString());
            }
        } catch (NumberFormatException exc) {
            System.err.println("Input data is incorrect");
            exc.printStackTrace();
        }

        IOData.writeResult(results);
    }
}
