package main.java.ru.ipolynkina.task6;

import main.java.ru.ipolynkina.IOData;

import java.util.ArrayList;
import java.util.List;

public class Rounding {
    public static void main(String[] args) {

        List<String> originalData = IOData.readOriginalData();
        List<String> result = new ArrayList<>();

        try {
            int amountNumbers = Integer.parseInt(originalData.get(0));
            for(int i = 1; i <= amountNumbers * 2; i += 2) {
                Integer dividend = Integer.parseInt(originalData.get(i));
                Integer divider = Integer.parseInt(originalData.get(i + 1));
                if(divider == 0) throw new NumberFormatException("divider == 0");

                Double quotient = (double) dividend / divider;
                if(quotient < 0) quotient -= 0.5;
                Long rounding = Math.round(quotient);
                result.add(rounding.toString());
            }
        } catch (NumberFormatException exc) {
            System.err.println("Input data is incorrect");
            exc.printStackTrace();
        }

        IOData.writeResult(result);
    }
}
