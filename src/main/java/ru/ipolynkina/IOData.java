package main.java.ru.ipolynkina;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IOData {

    public static List<String> readOriginalData() {
        List<String> originalData = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
            String line;
            List<String> words = new ArrayList<>();
            while((line = reader.readLine()) != null) {
                List<String> word = Arrays.asList(line.split(" "));
                words.addAll(word);
            }
            originalData.addAll(words);
        } catch(IOException exc) {
            exc.printStackTrace();
        }
        
        return originalData;
    }

    public static void writeResult(List<String> result) {
        try(FileWriter writer = new FileWriter("result.txt")) {
            writer.write(result.toString());
            writer.append("\n");
            writer.flush();
        } catch(IOException exc) {
            exc.printStackTrace();
        }
    }
}
