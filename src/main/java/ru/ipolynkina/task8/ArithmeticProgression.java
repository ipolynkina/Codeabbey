package main.java.ru.ipolynkina.task8;

import main.java.ru.ipolynkina.IOData;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticProgression {
    public static void main(String[] args) {

        List<String> originalData = IOData.readOriginalData();
        List<String> results = new ArrayList<>();

        try {
            int amountTests = Integer.parseInt(originalData.get(0));
            for(int i = 1; i <= amountTests * 3; i += 3) {
                int firstValue = Integer.parseInt(originalData.get(i));
                int sizeStep = Integer.parseInt(originalData.get(i + 1));
                int quantitySteps = Integer.parseInt(originalData.get(i + 2));

                int lastValue = firstValue + (quantitySteps - 1) * sizeStep;
                Integer result = (quantitySteps * (firstValue + lastValue)) / 2;
                results.add(result.toString());
            }
        } catch (NumberFormatException exc) {
            System.err.println("Input data is incorrect");
            exc.printStackTrace();
        }

        IOData.writeResult(results);
    }
}
