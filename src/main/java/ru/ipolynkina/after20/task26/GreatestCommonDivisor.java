package main.java.ru.ipolynkina.after20.task26;

import main.java.ru.ipolynkina.IOData;

import java.util.ArrayList;
import java.util.List;

public class GreatestCommonDivisor {
    public static void main(String[] args) {

        List<String> originalData = IOData.readOriginalData();
        List<String> results = new ArrayList<>();

        try {
            int amountTests = Integer.parseInt(originalData.get(0));
            for(int i = 1; i <= amountTests * 2; i += 2) {
                int numberA = Integer.parseInt(originalData.get(i));
                int numberB = Integer.parseInt(originalData.get(i + 1));
                int multiplicationAB = numberA * numberB;

                if(numberA > numberB) {
                    int tmp = numberA;
                    numberA = numberB;
                    numberB = tmp;
                }

                int gcd = numberA;
                while(numberB % numberA != 0) {
                    gcd = numberB % numberA;
                    numberB = numberA;
                    numberA = gcd;
                }
                results.add("(" + gcd);

                int lcm = multiplicationAB / gcd;
                results.add(lcm + ")");
            }
        } catch (NumberFormatException exc) {
            System.err.println("Input data is incorrect");
            exc.printStackTrace();
        }

        IOData.writeResult(results);
    }
}
