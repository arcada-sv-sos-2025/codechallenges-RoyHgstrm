package fi.arcada.codechallenge;

import java.util.ArrayList;

public class Statistics {
    
    public static double calcMean(ArrayList<Double> list) {
        double sum = 0;
        for (Double value : list) {
            sum += value;
        }
        return sum / list.size();
    }
    
    public static double getMode(ArrayList<Double> list) {
        int maxCount = 0;
        double item = 0;
        double currentElement;

        for (int i = 0; i < list.size(); i++) {
            currentElement = list.get(i);
            int count = 0;

            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).equals(currentElement)) {
                    count++;
                }
            }

            if (count > maxCount) {
                maxCount = count;
                item = currentElement;
            }
        }

        return item;
    }
} 