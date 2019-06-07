package main.java.ru.ipolynkina.after50.task57;

import main.java.ru.ipolynkina.IOData;

import java.util.ArrayList;
import java.util.List;

public class SmoothingTheWeather {
    public static void main(String[] args) {

        List<String> originalData = IOData.readOriginalData();
        List<String> results = new ArrayList<>();

        try {
            int amountTests = Integer.parseInt(originalData.get(0));
            if(amountTests > 1) results.add(originalData.get(1));
            for(int i = 2; i < amountTests; i++) {
                double firstValue = Double.parseDouble(originalData.get(i - 1));
                double secondValue = Double.parseDouble(originalData.get(i));
                double thirdValue = Double.parseDouble(originalData.get(i + 1));
                double averageValue = (firstValue + secondValue + thirdValue) / 3;
                results.add(String.valueOf(averageValue));
            }
            results.add(originalData.get(amountTests));
        } catch (NumberFormatException exc) {
            System.err.println("Input data is incorrect");
            exc.printStackTrace();
        }

        IOData.writeResult(results);
    }
}
