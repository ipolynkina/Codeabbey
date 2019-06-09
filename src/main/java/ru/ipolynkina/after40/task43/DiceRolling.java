package main.java.ru.ipolynkina.after40.task43;

import main.java.ru.ipolynkina.IOData;

import java.util.ArrayList;
import java.util.List;

public class DiceRolling {

    private static final int FIXED_INDEX = 6;

    public static void main(String[] args) {

        List<String> originalData = IOData.readOriginalData();
        List<String> results = new ArrayList<>();

        try {
            int amountTests = Integer.parseInt(originalData.get(0));
            for(int i = 1; i <= amountTests; i++) {
                double number = Double.parseDouble(originalData.get(i));
                int dice = (int) (number * FIXED_INDEX) + 1;
                results.add(String.valueOf(dice));
            }
        } catch (NumberFormatException exc) {
            System.err.println("Input data is incorrect");
            exc.printStackTrace();
        }

        IOData.writeResult(results);
    }
}
