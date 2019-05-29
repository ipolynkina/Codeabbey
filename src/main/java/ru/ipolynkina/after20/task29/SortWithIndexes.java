package main.java.ru.ipolynkina.after20.task29;

import main.java.ru.ipolynkina.IOData;

import java.util.*;

public class SortWithIndexes {
    public static void main(String[] args) {

        List<String> originalData = IOData.readOriginalData();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        List<String> results = new ArrayList<>();

        try {
            int amountNumbers = Integer.parseInt(originalData.get(0));
            for(int i = 1; i <= amountNumbers; i++) {
                map.put(Integer.parseInt(originalData.get(i)), i);
            }

            for(Map.Entry<Integer, Integer> pair : map.entrySet()) {
                results.add(pair.getValue().toString());
            }

        } catch (NumberFormatException exc) {
            System.err.println("Input data is incorrect");
            exc.printStackTrace();
        }

        IOData.writeResult(results);
    }
}
