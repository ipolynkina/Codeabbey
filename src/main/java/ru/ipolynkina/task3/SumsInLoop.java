package main.java.ru.ipolynkina.task3;

import main.java.ru.ipolynkina.IOData;

import java.util.ArrayList;
import java.util.List;

public class SumsInLoop {
    public static void main(String[] args) {

        List<String> originalData = IOData.readOriginalData();
        List<String> result = new ArrayList<>();

        try {
            int amountNumbers = Integer.parseInt(originalData.get(0));
            for(int i = 1; i <= amountNumbers * 2; i += 2) {
                Integer sum = Integer.parseInt(originalData.get(i));
                sum += Integer.parseInt(originalData.get(i + 1));
                result.add(sum.toString());
            }
        } catch (NumberFormatException exc) {
            System.err.println("Input data is incorrect");
            exc.printStackTrace();
        }

        IOData.writeResult(result);
    }
}
