package main.java.ru.ipolynkina.after50.task52;

import main.java.ru.ipolynkina.IOData;

import java.util.ArrayList;
import java.util.List;

public class PythagoreanTheorem {

    private static final String RIGHT_TRIANGLE = "R";
    private static final String ACUTE_TRIANGLE = "A";
    private static final String OBTUSE_TRIANGLE = "O";

    public static void main(String[] args) {

        List<String> originalData = IOData.readOriginalData();
        List<String> results = new ArrayList<>();

        try {
            int amountTests = Integer.parseInt(originalData.get(0));
            for(int i = 1; i <= amountTests * 3; i += 3) {
                int a = Integer.parseInt(originalData.get(i));
                int b = Integer.parseInt(originalData.get(i + 1));
                int c = Integer.parseInt(originalData.get(i + 2));

                int delta = (c * c) - ((a * a) + (b * b));
                if(delta == 0) results.add(RIGHT_TRIANGLE);
                else if(delta > 0) results.add(OBTUSE_TRIANGLE);
                else results.add(ACUTE_TRIANGLE);
            }
        } catch (NumberFormatException exc) {
            System.err.println("Input data is incorrect");
            exc.printStackTrace();
        }

        IOData.writeResult(results);
    }
}
