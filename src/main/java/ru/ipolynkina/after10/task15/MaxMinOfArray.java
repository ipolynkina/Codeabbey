package main.java.ru.ipolynkina.after10.task15;

import main.java.ru.ipolynkina.IOData;

import java.util.ArrayList;
import java.util.List;

public class MaxMinOfArray {

    private static final int AMOUNT_TESTS = 300;

    public static void main(String[] args) {

        List<String> originalData = IOData.readOriginalData();
        List<String> results = new ArrayList<>();

        try {
            Integer maxNumber = Integer.parseInt(originalData.get(0));
            Integer minNumber = maxNumber;

            for(int i = 1; i < AMOUNT_TESTS; i++) {
                int nextNumber = Integer.parseInt(originalData.get(i));
                maxNumber = nextNumber > maxNumber ? nextNumber : maxNumber;
                minNumber = nextNumber < minNumber ? nextNumber : minNumber;
            }

            results.add(maxNumber.toString());
            results.add(minNumber.toString());

        } catch (NumberFormatException exc) {
            System.err.println("Input data is incorrect");
            exc.printStackTrace();
        }

        IOData.writeResult(results);
    }
}
