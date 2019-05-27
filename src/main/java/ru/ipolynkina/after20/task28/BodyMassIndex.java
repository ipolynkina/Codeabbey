package main.java.ru.ipolynkina.after20.task28;

import main.java.ru.ipolynkina.IOData;

import java.util.ArrayList;
import java.util.List;

public class BodyMassIndex {
    public static void main(String[] args) {

        List<String> originalData = IOData.readOriginalData();
        List<String> results = new ArrayList<>();
        Double[] bodyIndex = {   18.5,     25.0,   30.0,   99.99};
        String[] bodyMass  = {"under", "normal", "over", "obese"};

        try {
            int amountTests = Integer.parseInt(originalData.get(0));
            for(int i = 1; i <= amountTests * 2; i += 2) {
                int weight = Integer.parseInt(originalData.get(i));
                double growth = Double.parseDouble(originalData.get(i + 1));
                double bmi = weight / (growth * growth);

                int index = 0;
                while(bmi > bodyIndex[index]) {
                    index++;
                }
                results.add(bodyMass[index]);
            }
        } catch (NumberFormatException exc) {
            System.err.println("Input data is incorrect");
            exc.printStackTrace();
        }

        IOData.writeResult(results);
    }
}
