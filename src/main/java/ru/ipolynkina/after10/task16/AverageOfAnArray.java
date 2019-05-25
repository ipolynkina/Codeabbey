package main.java.ru.ipolynkina.after10.task16;

import main.java.ru.ipolynkina.IOData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AverageOfAnArray {
    public static void main(String[] args) {

        List<String> originalData = IOData.readOriginalString();
        List<String> results = new ArrayList<>();

        try {
            int amountTests = Integer.parseInt(originalData.get(0));
            for(int i = 1; i <= amountTests; i++) {
                String string = originalData.get(i);
                List<String> numbers = Arrays.asList(string.split(" "));

                int sum = 0;
                for(String num : numbers) {
                    sum += Integer.parseInt(num);
                }

                if((numbers.size() - 1) > 0) {
                    Double result = (double) sum / (numbers.size() - 1);
                    if(result < 0) result -= 0.5;
                    results.add(String.valueOf(Math.round(result)));
                }
            }
        } catch (NumberFormatException exc) {
            System.err.println("Input data is incorrect");
            exc.printStackTrace();
        }

        IOData.writeResult(results);
    }
}
