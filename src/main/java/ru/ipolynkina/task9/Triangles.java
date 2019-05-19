package main.java.ru.ipolynkina.task9;

import main.java.ru.ipolynkina.IOData;

import java.util.ArrayList;
import java.util.List;

public class Triangles {
    public static void main(String[] args) {

        List<String> originalData = IOData.readOriginalData();
        List<String> results = new ArrayList<>();

        try {
            int amountTests = Integer.parseInt(originalData.get(0));
            for(int i = 1; i <= amountTests * 3; i += 3) {
                int a = Integer.parseInt(originalData.get(i));
                int b = Integer.parseInt(originalData.get(i + 1));
                int c = Integer.parseInt(originalData.get(i + 2));

                int sumSide = a + b + c;
                int maxSide = Math.max(a, Math.max(b, c));
                Integer result = maxSide < sumSide - maxSide ? 1 : 0;
                results.add(result.toString());
            }
        } catch (NumberFormatException exc) {
            System.err.println("Input data is incorrect");
            exc.printStackTrace();
        }

        IOData.writeResult(results);
    }
}
