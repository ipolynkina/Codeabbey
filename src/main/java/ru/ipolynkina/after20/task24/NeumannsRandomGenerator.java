package main.java.ru.ipolynkina.after20.task24;

import main.java.ru.ipolynkina.IOData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class NeumannsRandomGenerator {
    public static void main(String[] args) {

        List<String> originalData = IOData.readOriginalData();
        List<String> results = new ArrayList<>();

        try {
            int amountTests = Integer.parseInt(originalData.get(0));
            for(int i = 1; i <= amountTests; i++) {
                int number = Integer.parseInt(originalData.get(i));

                HashSet<Integer> hashSet = new HashSet<>();
                hashSet.add(number);
                while(true) {
                    Integer nextNumber = ((number * number) / 100) % 10_000;
                    if(hashSet.contains(nextNumber)) break;
                    hashSet.add(nextNumber);
                    number = nextNumber;
                }

                results.add(String.valueOf(hashSet.size()));
            }
        } catch (NumberFormatException exc) {
            System.err.println("Input data is incorrect");
            exc.printStackTrace();
        }

        IOData.writeResult(results);
    }
}
