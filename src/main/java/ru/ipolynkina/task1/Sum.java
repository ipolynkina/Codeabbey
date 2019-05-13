package main.java.ru.ipolynkina.task1;

import main.java.ru.ipolynkina.IOData;

import java.util.Arrays;
import java.util.List;

public class Sum {
    public static void main(String[] args) {

        List<String> originalData = IOData.readOriginalData();
        Integer numberA = 0;
        Integer numberB = 0;

        try {
            numberA = Integer.parseInt(originalData.get(0));
            numberB = Integer.parseInt(originalData.get(1));
        } catch (NumberFormatException exc) {
            System.err.println("Input data is incorrect");
            exc.printStackTrace();
        }

        Integer sum = numberA + numberB;
        IOData.writeResult(Arrays.asList(sum.toString()));
    }
}
