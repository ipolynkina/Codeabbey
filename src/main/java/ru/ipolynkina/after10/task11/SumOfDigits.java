package main.java.ru.ipolynkina.after10.task11;

import main.java.ru.ipolynkina.IOData;

import java.util.ArrayList;
import java.util.List;

public class SumOfDigits {

    private static final int CODE_ASCII = 48;

    public static void main(String[] args) {

        List<String> originalData = IOData.readOriginalData();
        List<String> results = new ArrayList<>();

        try {
            int amountTests = Integer.parseInt(originalData.get(0));
            for(int i = 1; i <= amountTests * 3; i += 3) {
                int a = Integer.parseInt(originalData.get(i));
                int b = Integer.parseInt(originalData.get(i + 1));
                int c = Integer.parseInt(originalData.get(i + 2));

                Integer totalDigit = a * b + c;
                Integer sumOfDigital = 0;
                for(int j = 0; j < totalDigit.toString().length(); j++) {
                    sumOfDigital += (totalDigit.toString().charAt(j) - CODE_ASCII);
                }
                results.add(sumOfDigital.toString());
            }
        } catch (NumberFormatException exc) {
            System.err.println("Input data is incorrect");
            exc.printStackTrace();
        }

        IOData.writeResult(results);
    }
}
