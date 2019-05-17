package main.java.ru.ipolynkina.task7;

import main.java.ru.ipolynkina.IOData;

import java.util.ArrayList;
import java.util.List;

public class FahrenheitToCelsius {
    public static void main(String[] args) {

        List<String> originalData = IOData.readOriginalData();
        List<String> result = new ArrayList<>();

        try {
            int amountNumbers = Integer.parseInt(originalData.get(0));
            for(int i = 1; i <= amountNumbers; i++) {
                Integer degreesFahrenheit = Integer.parseInt(originalData.get(i));
                Long degreesCelsius = Math.round((degreesFahrenheit - 32) / 1.8);
                result.add(degreesCelsius.toString());

            }
        } catch (NumberFormatException exc) {
            System.err.println("Input data is incorrect");
            exc.printStackTrace();
        }

        IOData.writeResult(result);
    }
}
