package main.java.ru.ipolynkina.after40.task42;

import main.java.ru.ipolynkina.IOData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlackjackCounting {

    public static final int MAX_POINTS = 21;

    public static void main(String[] args) {

        List<String> originalData = IOData.readOriginalString();
        List<String> results = new ArrayList<>();
        Map<String, Integer> cards = new HashMap<String, Integer>() {{
            put("2", 2); put("3", 3); put("4", 4); put("5", 5);
            put("6", 6); put("7", 7); put("8", 8); put("9", 9);
            put("T", 10); put("J", 10); put("Q", 10); put("K", 10); put("A", 11);
        }};

        try {
            int amountTests = Integer.parseInt(originalData.get(0));
            for(int i = 1; i <= amountTests; i++) {
                String[] selectedCards = originalData.get(i).split(" ");
                int points = 0;
                int numberOfAces = 0;
                for (String selectedCard : selectedCards) {
                    points += cards.get(selectedCard);
                    if (cards.get(selectedCard) == 11) ++numberOfAces;
                }

                while (numberOfAces-- > 0) {
                    if(points > MAX_POINTS) points -= 10;
                }

                if(points > MAX_POINTS) results.add("Bust");
                else results.add(String.valueOf(points));
            }
        } catch (NumberFormatException exc) {
            System.err.println("Input data is incorrect");
            exc.printStackTrace();
        }

        IOData.writeResult(results);
    }
}
