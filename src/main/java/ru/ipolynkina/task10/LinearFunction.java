package main.java.ru.ipolynkina.task10;

import main.java.ru.ipolynkina.IOData;

import java.util.ArrayList;
import java.util.List;

/**
 * ax1 + b = y1
 * b = y1 - ax1
 *
 * ax2 + y1 - ax1 = y2
 * ax2 - ax1 = y2 - y1
 * a(x2 - x1) = y2 - y1
 * a = (y2 - y1) / (x2 - x1)
 */

public class LinearFunction {
    public static void main(String[] args) {

        List<String> originalData = IOData.readOriginalData();
        List<String> results = new ArrayList<>();

        try {
            int amountTests = Integer.parseInt(originalData.get(0));
            for(int i = 1; i <= amountTests * 4; i += 4) {
                int x1 = Integer.parseInt(originalData.get(i));
                int y1 = Integer.parseInt(originalData.get(i + 1));
                int x2 = Integer.parseInt(originalData.get(i + 2));
                int y2 = Integer.parseInt(originalData.get(i + 3));

                if(x2 - x1 == 0) throw new NumberFormatException("divider == 0");
                Integer a = (y2 - y1) / (x2 - x1);
                Integer b = y1 - (a * x1);
                results.add("(" + a.toString());
                results.add(b.toString() + ")");
            }
        } catch (NumberFormatException exc) {
            System.err.println("Input data is incorrect");
            exc.printStackTrace();
        }

        IOData.writeResult(results);
    }
}
