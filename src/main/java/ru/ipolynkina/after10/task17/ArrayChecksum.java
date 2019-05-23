package main.java.ru.ipolynkina.after10.task17;

import main.java.ru.ipolynkina.IOData;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

public class ArrayChecksum {
    public static void main(String[] args) {

        List<String> originalData = IOData.readOriginalData();
        BigInteger checksum = BigInteger.valueOf(0);

        try {
            int amountNumbers = Integer.parseInt(originalData.get(0));
            for(int i = 1; i <= amountNumbers; i++) {
                BigInteger nextNumber = BigInteger.valueOf(Integer.parseInt(originalData.get(i)));
                checksum = checksum.add(nextNumber);
                checksum = checksum.multiply(BigInteger.valueOf(113));
                checksum = checksum.mod(BigInteger.valueOf(10000007));
            }

        } catch (NumberFormatException exc) {
            System.err.println("Input data is incorrect");
            exc.printStackTrace();
        }

        IOData.writeResult(Collections.singletonList(checksum.toString()));
    }
}
