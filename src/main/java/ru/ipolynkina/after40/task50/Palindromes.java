package main.java.ru.ipolynkina.after40.task50;

import main.java.ru.ipolynkina.IOData;

import java.util.ArrayList;
import java.util.List;

public class Palindromes {
    public static void main(String[] args) {

        List<String> originalData = IOData.readOriginalString();
        List<String> results = new ArrayList<>();

        try {
            int amountTests = Integer.parseInt(originalData.get(0));
            for(int i = 1; i <= amountTests; i++) {
                String string = originalData.get(i).replaceAll("[^a-zA-Z]", "").toLowerCase();
                StringBuilder reverseString = new StringBuilder(string).reverse();
                String answer = string.equals(reverseString.toString()) ? "Y" : "N";
                results.add(answer);
            }
        } catch (NumberFormatException exc) {
            System.err.println("Input data is incorrect");
            exc.printStackTrace();
        }

        IOData.writeResult(results);
    }
}
