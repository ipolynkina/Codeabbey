package main.java.ru.ipolynkina.after30.task33;

import main.java.ru.ipolynkina.IOData;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

public class ParityControl {

    private static final int LAST_BIT = 7;

    public static void main(String[] args) {

        List<String> originalData = IOData.readOriginalString();
        String[] numbers = originalData.get(0).split(" ");
        StringBuilder result = new StringBuilder();

        try {
            for (String number : numbers) {
                BigInteger bigNumber = BigInteger.valueOf(Integer.parseInt(number));
                if(bigNumber.bitCount() % 2 != 0) continue;
                bigNumber = bigNumber.clearBit(LAST_BIT);
                result.append((char) bigNumber.intValue());
            }
        } catch (NumberFormatException exc) {
            System.err.println("Input data is incorrect");
            exc.printStackTrace();
        }

        IOData.writeResult(Collections.singletonList(result.toString()));
    }
}
