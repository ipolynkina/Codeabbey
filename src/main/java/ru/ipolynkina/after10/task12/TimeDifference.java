package main.java.ru.ipolynkina.after10.task12;

import main.java.ru.ipolynkina.IOData;

import java.util.ArrayList;
import java.util.List;

public class TimeDifference {

    private static final int SECONDS_IN_DAY = 24 * 60 * 60;
    private static final int SECONDS_IN_HOUR = 60 * 60;
    private static final int SECONDS_IN_MINUTE = 60;


    public static void main(String[] args) {

        List<String> originalData = IOData.readOriginalData();
        List<String> results = new ArrayList<>();

        try {
            int amountTests = Integer.parseInt(originalData.get(0));
            for(int i = 1; i <= amountTests * 8; i += 8) {
                int day1 = Integer.parseInt(originalData.get(i));
                int hour1 = Integer.parseInt(originalData.get(i + 1));
                int minute1 = Integer.parseInt(originalData.get(i + 2));
                int second1 = Integer.parseInt(originalData.get(i + 3));

                int day2 = Integer.parseInt(originalData.get(i + 4));
                int hour2 = Integer.parseInt(originalData.get(i + 5));
                int minute2 = Integer.parseInt(originalData.get(i + 6));
                int second2 = Integer.parseInt(originalData.get(i + 7));

                int time1 = day1 * SECONDS_IN_DAY + hour1 * SECONDS_IN_HOUR + minute1 * SECONDS_IN_MINUTE + second1;
                int time2 = day2 * SECONDS_IN_DAY + hour2 * SECONDS_IN_HOUR + minute2 * SECONDS_IN_MINUTE + second2;
                int deltaSecondsTotal = time2 - time1;

                Integer deltaDays = deltaSecondsTotal / SECONDS_IN_DAY;
                int remainderSeconds = deltaSecondsTotal % SECONDS_IN_DAY;

                Integer deltaHours = remainderSeconds / SECONDS_IN_HOUR;
                remainderSeconds = remainderSeconds % SECONDS_IN_HOUR;

                Integer deltaMinutes = remainderSeconds / SECONDS_IN_MINUTE;

                Integer deltaSeconds = remainderSeconds % SECONDS_IN_MINUTE;

                results.add("(" + deltaDays.toString());
                results.add(deltaHours.toString());
                results.add(deltaMinutes.toString());
                results.add(deltaSeconds.toString() + ")");
            }
        } catch (NumberFormatException exc) {
            System.err.println("Input data is incorrect");
            exc.printStackTrace();
        }

        IOData.writeResult(results);
    }
}
