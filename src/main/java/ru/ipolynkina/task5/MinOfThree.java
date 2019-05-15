package main.java.ru.ipolynkina.task5;

import main.java.ru.ipolynkina.IOData;

import java.util.ArrayList;
import java.util.List;

public class MinOfThree {
    public static void main(String[] args) {

        List<String> originalData = IOData.readOriginalData();
        List<String> result = new ArrayList<>();

        try {
            int amountNumbers = Integer.parseInt(originalData.get(0));
            for(int i = 1; i <= amountNumbers * 3; i += 3) {
                int num1 = Integer.parseInt(originalData.get(i));
                int num2 = Integer.parseInt(originalData.get(i + 1));
                int num3 = Integer.parseInt(originalData.get(i + 2));
                Integer min = Math.min(num1, Math.min(num2, num3));
                result.add(min.toString());
            }
        } catch (NumberFormatException exc) {
            System.err.println("Input data is incorrect");
            exc.printStackTrace();
        }

        IOData.writeResult(result);
    }
}
