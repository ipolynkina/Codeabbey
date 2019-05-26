package main.java.ru.ipolynkina.after10.task18;

import main.java.ru.ipolynkina.IOData;

import java.util.ArrayList;
import java.util.List;

public class SquareRoot {
    public static void main(String[] args) {

        List<String> originalData = IOData.readOriginalData();
        List<String> results = new ArrayList<>();

        try {
            int amountTests = Integer.parseInt(originalData.get(0));
            for(int i = 1; i <= amountTests * 2; i += 2) {
                int number = Integer.parseInt(originalData.get(i));
                int amountSteps = Integer.parseInt(originalData.get(i + 1));

                Double root = 1.0;
                for(int j = 0; j < amountSteps; j++) {
                    root = (root + number / root) / 2;
                }

                results.add(root.toString());
            }
        } catch (NumberFormatException exc) {
            System.err.println("Input data is incorrect");
            exc.printStackTrace();
        }

        IOData.writeResult(results);
    }
}
