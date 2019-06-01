package main.java.ru.ipolynkina.after20.task22;

import main.java.ru.ipolynkina.IOData;

import java.util.ArrayList;
import java.util.List;

public class TwoPrinters {
    public static void main(String[] args) {

        List<String> originalData = IOData.readOriginalData();
        List<String> results = new ArrayList<>();

        try {
            int amountTests = Integer.parseInt(originalData.get(0));
            for(int i = 1; i <= amountTests * 3; i += 3) {
                int printerSpeedA = Integer.parseInt(originalData.get(i));
                int printerSpeedB = Integer.parseInt(originalData.get(i + 1));
                int numberOfPages = Integer.parseInt(originalData.get(i + 2));

                // rounding down
                int pagesForPrinterA = numberOfPages * printerSpeedB / (printerSpeedA + printerSpeedB);
                int pagesForPrinterB = numberOfPages - pagesForPrinterA;
                int maxTimePrintDown = Math.max(printerSpeedA * pagesForPrinterA, printerSpeedB * pagesForPrinterB);

                // rounding up
                pagesForPrinterA += 1;
                pagesForPrinterB -= 1;
                int maxTimePrintUp = Math.max(printerSpeedA * pagesForPrinterA, printerSpeedB * pagesForPrinterB);

                int minTimePrint = Math.min(maxTimePrintDown, maxTimePrintUp);
                results.add(String.valueOf(minTimePrint));
            }
        } catch (NumberFormatException exc) {
            System.err.println("Input data is incorrect");
            exc.printStackTrace();
        }

        IOData.writeResult(results);
    }
}
