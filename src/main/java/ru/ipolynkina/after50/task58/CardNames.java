package main.java.ru.ipolynkina.after50.task58;

import main.java.ru.ipolynkina.IOData;

import java.util.ArrayList;
import java.util.List;

public class CardNames {
    public static void main(String[] args) {

        List<String> originalData = IOData.readOriginalData();
        List<String> results = new ArrayList<>();

        String[] suit = {"Clubs", "Spades", "Diamonds", "Hearts"};
        String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        try {
            int amountTests = Integer.parseInt(originalData.get(0));
            for(int i = 1; i <= amountTests; i++) {
                int randomNumber = Integer.parseInt(originalData.get(i));
                int indexSuit = randomNumber / 13;
                int indexRank = randomNumber % 13;
                results.add(rank[indexRank] + "-of-" + suit[indexSuit]);
            }
        } catch (NumberFormatException exc) {
            System.err.println("Input data is incorrect");
            exc.printStackTrace();
        }

        IOData.writeResult(results);
    }
}
