package main.java.ru.ipolynkina.after20.task30;

import main.java.ru.ipolynkina.IOData;

import java.util.Collections;
import java.util.List;

public class ReverseString {
    public static void main(String[] args) {

        List<String> originalData = IOData.readOriginalString();
        String originalString = originalData.get(0);
        String reverseString = new StringBuffer(originalString).reverse().toString();
        IOData.writeResult(Collections.singletonList(reverseString));

        char[] str = originalString.toCharArray();
        for(int i = 0; i < str.length / 2; i++) {
            char temp = str[str.length - i - 1];
            str[str.length - i - 1] = str[i];
            str[i] = temp;
        }

        if(!reverseString.equals(new String(str))) {
            System.err.println("Incorrect result!");
        }
    }
}
