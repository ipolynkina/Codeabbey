package main.java.ru.ipolynkina.after10.task14;

import main.java.ru.ipolynkina.IOData;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

public class ModularCalculator {
    public static void main(String[] args) {

        List<String> originalData = IOData.readOriginalData();

        try {
            BigInteger number = BigInteger.valueOf(Integer.parseInt(originalData.get(0)));
            for(int i = 1; i < originalData.size(); i += 2) {
                String sign = originalData.get(i);
                BigInteger nextNumber = BigInteger.valueOf(Integer.parseInt(originalData.get(i + 1)));

                switch(sign) {
                    case "+": number = number.add(nextNumber); break;
                    case "*": number = number.multiply(nextNumber); break;
                    case "%": number = number.mod(nextNumber); break;
                    default: throw new NumberFormatException("incorrect sign: " + sign);
                }
            }

            IOData.writeResult(Collections.singletonList(number.toString()));

        } catch (NumberFormatException exc) {
            System.err.println("Input data is incorrect");
            exc.printStackTrace();
        }
    }
}
