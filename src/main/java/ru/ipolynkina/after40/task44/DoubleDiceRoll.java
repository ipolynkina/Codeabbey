package main.java.ru.ipolynkina.after40.task44;

import main.java.ru.ipolynkina.IOData;

import java.util.ArrayList;
import java.util.List;

public class DoubleDiceRoll {

    private static final int FIXED_INDEX = 6;

    public static void main(String[] args) {

        List<String> originalData = IOData.readOriginalData();
        List<String> results = new ArrayList<>();

        try {
            int amountTests = Integer.parseInt(originalData.get(0));
            for(int i = 1; i <= amountTests * 2; i += 2) {
                int number1 = Integer.parseInt(originalData.get(i));
                int number2 = Integer.parseInt(originalData.get(i + 1));
                int dice = (number1 % FIXED_INDEX) + (number2 % FIXED_INDEX) + 2;
                results.add(String.valueOf(dice));
            }
        } catch (NumberFormatException exc) {
            System.err.println("Input data is incorrect");
            exc.printStackTrace();
        }

        IOData.writeResult(results);
    }
}
