package com.incubyte.application;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringCalc {

    public int calculate(String numbers) {
        //Default to Zero
        int sum=0;

        if (numbers.isEmpty()) {
            return sum;
        }

        String[] individualNumbers = parseString(numbers);
        for (String individualNumber : individualNumbers) {
            sum += Integer.parseInt(individualNumber);
        }

        return sum;
    }

    private String[] parseString(String numbers) {

        System.out.println(Arrays.toString(numbers.split(",")));

        return numbers.split(",");
    }
}
