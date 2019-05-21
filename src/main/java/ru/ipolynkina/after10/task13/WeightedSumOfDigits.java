package main.java.ru.ipolynkina.after10.task13;

import main.java.ru.ipolynkina.IOData;

import java.util.ArrayList;
import java.util.List;

public class WeightedSumOfDigits {

    private static final int CODE_ASCII = 48;

    public static void main(String[] args) {

        List<String> originalData = IOData.readOriginalData();
        List<String> results = new ArrayList<>();

        try {
            int amountTests = Integer.parseInt(originalData.get(0));
            for(int i = 1; i <= amountTests; i++) {
                String strNumber = originalData.get(i);

                Integer sumOfDigits = 0;
                for(int j = 0; j < strNumber.length(); j++) {
                    sumOfDigits += (strNumber.charAt(j) - CODE_ASCII) * (j + 1);
                }
                results.add(sumOfDigits.toString());
            }
        } catch (NumberFormatException exc) {
            System.err.println("Input data is incorrect");
            exc.printStackTrace();
        }

        IOData.writeResult(results);
    }
}
