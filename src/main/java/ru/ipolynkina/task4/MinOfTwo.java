package main.java.ru.ipolynkina.task4;

import main.java.ru.ipolynkina.IOData;

import java.util.ArrayList;
import java.util.List;

public class MinOfTwo {
    public static void main(String[] args) {

        List<String> originalData = IOData.readOriginalData();
        List<String> result = new ArrayList<>();

        try {
            int amountNumbers = Integer.parseInt(originalData.get(0));
            for(int i = 1; i <= amountNumbers * 2; i += 2) {
                Integer num1 = Integer.parseInt(originalData.get(i));
                Integer num2 = Integer.parseInt(originalData.get(i + 1));
                Integer min = num1 < num2 ? num1 : num2;
                result.add(min.toString());
            }
        } catch (NumberFormatException exc) {
            System.err.println("Input data is incorrect");
            exc.printStackTrace();
        }

        IOData.writeResult(result);
    }
}
