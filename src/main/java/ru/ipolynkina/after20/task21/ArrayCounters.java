package main.java.ru.ipolynkina.after20.task21;

import main.java.ru.ipolynkina.IOData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayCounters {
    public static void main(String[] args) {

        List<String> originalData = IOData.readOriginalData();
        List<String> results = new ArrayList<>();

        try {
            int amountNumbers = Integer.parseInt(originalData.get(0));
            int maxNumber = Integer.parseInt(originalData.get(1));
            Integer[] counters = new Integer[maxNumber];
            Arrays.fill(counters, 0);

            for(int i = 2; i <= amountNumbers + 1; i++) {
                counters[(Integer.parseInt(originalData.get(i))) - 1]++;
            }

            for(int i = 0; i < maxNumber; i++) {
                results.add(counters[i].toString());
            }

        } catch (NumberFormatException exc) {
            System.err.println("Input data is incorrect");
            exc.printStackTrace();
        }

        IOData.writeResult(results);
    }
}
