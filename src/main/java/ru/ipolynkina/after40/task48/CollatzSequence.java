package main.java.ru.ipolynkina.after40.task48;

import main.java.ru.ipolynkina.IOData;

import java.util.ArrayList;
import java.util.List;

public class CollatzSequence {
    public static void main(String[] args) {

        List<String> originalData = IOData.readOriginalData();
        List<String> results = new ArrayList<>();

        try {
            int amountTests = Integer.parseInt(originalData.get(0));
            for(int i = 1; i <= amountTests; i++) {
                int number = Integer.parseInt(originalData.get(i));
                int counter = 0;
                while(number != 1) {
                    number = number % 2 == 0 ? number / 2 : 3 * number + 1;
                    counter++;
                }
                results.add(String.valueOf(counter));
            }
        } catch (NumberFormatException exc) {
            System.err.println("Input data is incorrect");
            exc.printStackTrace();
        }

        IOData.writeResult(results);
    }
}
