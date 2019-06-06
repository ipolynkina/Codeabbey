package main.java.ru.ipolynkina.after50.task59;

import main.java.ru.ipolynkina.IOData;

import java.util.ArrayList;
import java.util.List;

public class BullsAndCows {

    private static int calcCorrectPositions(String secretCode, String numberGuess) {
        int correctPositions = 0;
        for(int i = 0; i < secretCode.length() && i < numberGuess.length(); i++) {
            if(secretCode.charAt(i) == numberGuess.charAt(i)) correctPositions++;
        }
        return correctPositions;
    }

    private static int calcWrongPositions(String secretCode, String numberGuess) {
        int wrongPositions = 0;
        for(int i = 0; i < secretCode.length() && i < numberGuess.length(); i++) {
            char secretChar = secretCode.charAt(i);
            for(int j = 0; j < numberGuess.length(); j++) {
                char guessChar = numberGuess.charAt(j);
                if(secretChar == guessChar && i != j) wrongPositions++;
            }
        }
        return wrongPositions;
    }

    public static void main(String[] args) {

        List<String> originalData = IOData.readOriginalData();
        List<String> results = new ArrayList<>();

        try {
            String secretCode = originalData.get(0);
            int amountTests = Integer.parseInt(originalData.get(1));
            for(int i = 2; i < amountTests + 2; i++) {
                String numberGuess = originalData.get(i);
                int correctPosition = calcCorrectPositions(secretCode, numberGuess);
                int wrongPosition = calcWrongPositions(secretCode, numberGuess);
                results.add(correctPosition + "-" + wrongPosition);
            }
        } catch (NumberFormatException exc) {
            System.err.println("Input data is incorrect");
            exc.printStackTrace();
        }

        IOData.writeResult(results);
    }
}
