package main.java.ru.ipolynkina.after30.task35;

import main.java.ru.ipolynkina.IOData;

import java.util.ArrayList;
import java.util.List;

public class SavingsCalculator {
    public static void main(String[] args) {

        List<String> originalData = IOData.readOriginalData();
        List<String> results = new ArrayList<>();

        try {
            int amountTests = Integer.parseInt(originalData.get(0));
            for(int i = 1; i <= amountTests * 3; i += 3) {
                double startSum = Double.parseDouble(originalData.get(i));
                double requiredSum = Double.parseDouble(originalData.get(i + 1));
                int rate = Integer.parseInt(originalData.get(i + 2));
                int years = 0;

                while(startSum < requiredSum) {
                    startSum += (startSum * rate / 100);
                    years++;
                }

                results.add(String.valueOf(years));
            }
        } catch (NumberFormatException exc) {
            System.err.println("Input data is incorrect");
            exc.printStackTrace();
        }

        IOData.writeResult(results);
    }
}
