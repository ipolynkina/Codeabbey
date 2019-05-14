package main.java.ru.ipolynkina.task2;

import main.java.ru.ipolynkina.IOData;

import java.util.Arrays;
import java.util.List;

public class SumInLoop {
    public static void main(String[] args) {

        List<String> originalData = IOData.readOriginalData();
        Integer sum = 0;

        try {
            int amountNumbers = Integer.parseInt(originalData.get(0));
            for(int i = 1; i <= amountNumbers; i++) {
                sum += Integer.parseInt(originalData.get(i));
            }
        } catch (NumberFormatException exc) {
            System.err.println("Input data is incorrect");
            exc.printStackTrace();
        }

        IOData.writeResult(Arrays.asList(sum.toString()));
    }
}