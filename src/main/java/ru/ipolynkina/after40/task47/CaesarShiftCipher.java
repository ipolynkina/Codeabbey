package main.java.ru.ipolynkina.after40.task47;

import main.java.ru.ipolynkina.IOData;

import java.util.ArrayList;
import java.util.List;

public class CaesarShiftCipher {

    private static final int MIN_CHAR = 65;
    private static final int MAX_CHAR = 90;

    public static void main(String[] args) {

        List<String> originalData = IOData.readOriginalString();
        List<String> results = new ArrayList<>();

        try {
            String[] conditions = originalData.get(0).split(" ");
            int amountTests = Integer.parseInt(conditions[0]);
            int offset = Integer.parseInt(conditions[1]);
            for(int i = 1; i <= amountTests; i++) {
                StringBuilder sb = new StringBuilder(originalData.get(i));
                for(int j = 0; j < sb.length(); j++) {
                    char ch = sb.charAt(j);
                    if(ch >= MIN_CHAR && ch <= MAX_CHAR) {
                        int newCh = (int) ch - offset;
                        if(newCh < MIN_CHAR) newCh = MAX_CHAR - (MIN_CHAR - newCh - 1);
                        sb.setCharAt(j, (char) newCh);
                    }
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
