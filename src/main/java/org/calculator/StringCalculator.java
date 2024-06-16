package org.calculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

  public int add(String numbers) {
    if (numbers.isEmpty()) {
      return 0;
    }

    String delimiter = ",|\n";
    if (numbers.startsWith("//")) {
      int delimiterIndex = numbers.indexOf('\n');
      delimiter = numbers.substring(2, delimiterIndex);
      numbers = numbers.substring(delimiterIndex + 1);
    }

    String[] tokens = numbers.split(delimiter);
    int sum = 0;
    List<Integer> negatives = new ArrayList<>();
    for (String token : tokens) {
      int number = Integer.parseInt(token);
      if (number < 0) {
        negatives.add(number);
      }
      sum += number;
    }

    if (!negatives.isEmpty()) {
      throw new IllegalArgumentException("Negatives not allowed: " + negatives.toString());
    }

    return sum;
  }
}

