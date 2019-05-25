package main.java.ru.ipolynkina.after10.task19;

import main.java.ru.ipolynkina.IOData;

import java.util.*;

public class MatchingBrackets {
    public static void main(String[] args) {

        List<String> originalData = IOData.readOriginalString();
        List<String> results = new ArrayList<>();
        HashMap<Character, Character> brackets = new HashMap<Character, Character>() {{
            put('(', ')');
            put('{', '}');
            put('[', ']');
            put('<', '>');
        }};

        try {
            int amountTests = Integer.parseInt(originalData.get(0));
            for(int i = 1; i <= amountTests; i++) {
                String testString = originalData.get(i);
                Stack<Character> stack = new Stack<>();
                Integer statusOk = 1;

                for(int j = 0; j < testString.length(); j++) {
                    Character currentChar = testString.charAt(j);
                    if(brackets.containsKey(currentChar)) stack.push(currentChar);
                    else if(brackets.containsValue(currentChar)) {
                        if(stack.empty() || !brackets.get(stack.pop()).equals(currentChar)) {
                            statusOk = 0;
                            break;
                        }
                    }
                }

                if(!stack.empty()) statusOk = 0;
                results.add(statusOk.toString());
            }
        } catch (NumberFormatException exc) {
            System.err.println("Input data is incorrect");
            exc.printStackTrace();
        }

        IOData.writeResult(results);
    }
}
