package org.joseph.utils;

public class DataParser {
    public static String trimMaker(String[] splittedName){
        StringBuilder restOfWords = new StringBuilder();
        for (int i = 2; i < splittedName.length; i++) {
            restOfWords.append(splittedName[i]);
            if (i < splittedName.length - 1) {
                restOfWords.append(" ");
            }
        }
        return restOfWords.toString();
    }
    public static float convertPrice(String priceString) {
        final float exchangeRate = 59.6f;
        String numericValue = priceString.replaceAll("[^0-9,]", "").replace(",", "");
        float value = Float.parseFloat(numericValue);
        if (priceString.contains("US$")) {
            value *= exchangeRate;
        }
        return value;
    }
}