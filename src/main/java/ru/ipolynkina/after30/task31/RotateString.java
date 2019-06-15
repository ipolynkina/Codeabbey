package main.java.ru.ipolynkina.after30.task31;

import main.java.ru.ipolynkina.IOData;

import java.util.ArrayList;
import java.util.List;

public class RotateString {
    public static void main(String[] args) {

        List<String> originalData = IOData.readOriginalData();
        List<String> results = new ArrayList<>();

        try {
            int amountTests = Integer.parseInt(originalData.get(0));
            for(int i = 1; i <= amountTests * 2; i += 2) {
                int numberOfCoups = Integer.parseInt(originalData.get(i));
                StringBuilder sb = new StringBuilder(originalData.get(i + 1));

                if(numberOfCoups < 0) numberOfCoups = sb.length() + numberOfCoups;
                while(numberOfCoups-- > 0) {
                    char ch = sb.charAt(0);
                    sb.deleteCharAt(0);
                    sb.append(ch);
                }

                results.add(sb.toString());
            }
        } catch (NumberFormatException exc) {
            System.err.println("Input data is incorrect");
            exc.printStackTrace();
        }

        IOData.writeResult(results);
    }
}
