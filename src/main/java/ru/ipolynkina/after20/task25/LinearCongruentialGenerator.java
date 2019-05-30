package main.java.ru.ipolynkina.after20.task25;

import main.java.ru.ipolynkina.IOData;

import java.util.ArrayList;
import java.util.List;

/**
 * problem formula:
 * X next = (A * X current + C) % M
 */

public class LinearCongruentialGenerator {
    public static void main(String[] args) {

        List<String> originalData = IOData.readOriginalData();
        List<String> results = new ArrayList<>();

        try {
            int amountTests = Integer.parseInt(originalData.get(0));
            for(int i = 1; i <= amountTests * 5; i += 5) {
                int A = Integer.parseInt(originalData.get(i));
                int C = Integer.parseInt(originalData.get(i + 1));
                int M = Integer.parseInt(originalData.get(i + 2));
                int X = Integer.parseInt(originalData.get(i + 3));
                int amountCycles = Integer.parseInt(originalData.get(i + 4));

                for(int j = 0; j < amountCycles; j++) {
                    X = (A * X + C) % M;
                }

                results.add(String.valueOf(X));
            }
        } catch (NumberFormatException exc) {
            System.err.println("Input data is incorrect");
            exc.printStackTrace();
        }

        IOData.writeResult(results);
    }
}
