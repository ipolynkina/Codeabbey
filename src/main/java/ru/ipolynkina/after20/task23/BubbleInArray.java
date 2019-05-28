package main.java.ru.ipolynkina.after20.task23;

import main.java.ru.ipolynkina.IOData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BubbleInArray {
    public static void main(String[] args) {

        List<String> originalData = IOData.readOriginalString();
        List<String> originalString = Arrays.asList(originalData.get(0).split(" "));
        List<Integer> numbers = new ArrayList<>();
        List<String> results = new ArrayList<>();

        try {
            for(int i = 0; i < originalString.size() - 1; i++) {
                numbers.add(Integer.valueOf(originalString.get(i)));
            }

            Integer permutationCounter = 0;
            for(int i = 1; i < numbers.size(); i++) {
                if(numbers.get(i) < numbers.get(i - 1)) {
                    permutationCounter++;
                    int temp = numbers.get(i);
                    numbers.set(i, numbers.get(i - 1));
                    numbers.set(i - 1, temp);
                }
            }
            results.add(permutationCounter.toString());

            Integer checkSum = 0;
            for(int i = 0; i < numbers.size(); i++) {
                checkSum = (checkSum + numbers.get(i)) * 113 % 10000007;
            }
            results.add(checkSum.toString());

        } catch (NumberFormatException exc) {
            System.err.println("Input data is incorrect");
            exc.printStackTrace();
        }

        IOData.writeResult(results);
    }
}
