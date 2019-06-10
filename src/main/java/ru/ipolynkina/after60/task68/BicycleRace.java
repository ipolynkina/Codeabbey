package main.java.ru.ipolynkina.after60.task68;

import main.java.ru.ipolynkina.IOData;

import java.util.ArrayList;
import java.util.List;

public class BicycleRace {
    public static void main(String[] args) {

        List<String> originalData = IOData.readOriginalData();
        List<String> results = new ArrayList<>();

        try {
            int amountTests = Integer.parseInt(originalData.get(0));
            for(int i = 1; i <= amountTests * 3; i += 3) {
                int s = Integer.parseInt(originalData.get(i));
                int a = Integer.parseInt(originalData.get(i + 1));
                int b = Integer.parseInt(originalData.get(i + 2));
                double timeMeet = (double) s / (a + b);
                double distance = timeMeet * a;
                results.add(String.valueOf(distance));
            }
        } catch (NumberFormatException exc) {
            System.err.println("Input data is incorrect");
            exc.printStackTrace();
        }

        IOData.writeResult(results);
    }
}
