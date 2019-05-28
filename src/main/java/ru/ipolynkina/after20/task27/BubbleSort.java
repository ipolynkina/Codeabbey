package main.java.ru.ipolynkina.after20.task27;

import main.java.ru.ipolynkina.IOData;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort {
    public static void main(String[] args) {

        List<String> originalData = IOData.readOriginalData();
        List<Integer> numbers = new ArrayList<>();
        List<String> results = new ArrayList<>();

        try {
            int amountTests = Integer.parseInt(originalData.get(0));
            for(int i = 1; i <= amountTests; i++) {
                numbers.add(Integer.parseInt(originalData.get(i)));
            }

            Integer amountOfPasses = 1;
            Integer permutationCounter = 0;
            for(int i = 1; i < numbers.size(); i++) {
                boolean passesIsNeed = false;
                for(int j = 1; j < numbers.size(); j++) {
                    if(numbers.get(j) < numbers.get(j - 1)) {
                        passesIsNeed = true;
                        permutationCounter++;
                        int temp = numbers.get(j);
                        numbers.set(j, numbers.get(j - 1));
                        numbers.set(j - 1, temp);
                    }
                }
                if(passesIsNeed) amountOfPasses++;
                else break;
            }

            results.add(amountOfPasses.toString());
            results.add(permutationCounter.toString());

        } catch (NumberFormatException exc) {
            System.err.println("Input data is incorrect");
            exc.printStackTrace();
        }

        IOData.writeResult(results);
    }
}
