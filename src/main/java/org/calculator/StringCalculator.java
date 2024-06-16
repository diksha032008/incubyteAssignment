package org.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

  public int add(String numbers) {
    if (numbers.isEmpty()) {
      return 0;
    }

    String delimiter = ",|\n";
    String nums = numbers;
    if (numbers.startsWith("//")) {
      int delimiterIndex = numbers.indexOf('\n');
      String delimiterPart = numbers.substring(2, delimiterIndex);
      nums = numbers.substring(delimiterIndex + 1);

      Pattern pattern = Pattern.compile("\\[(.*?)\\]");
      Matcher matcher = pattern.matcher(delimiterPart);
      StringBuilder delimiters = new StringBuilder();
      while (matcher.find()) {
        if (delimiters.length() > 0) {
          delimiters.append("|");
        }
        delimiters.append(Pattern.quote(matcher.group(1)));
      }
      if (delimiters.length() > 0) {
        delimiter = delimiters.toString();
      } else {
        delimiter = Pattern.quote(delimiterPart);
      }
    }

    String[] tokens = nums.split(delimiter);
    int sum = 0;
    List<Integer> negatives = new ArrayList<>();
    for (String token : tokens) {
      if (!token.isEmpty()) {
        int number = Integer.parseInt(token);
        if (number < 0) {
          negatives.add(number);
        } else if (number <= 1000) {
          sum += number;
        }
      }
    }

    if (!negatives.isEmpty()) {
      throw new IllegalArgumentException("Negatives not allowed: " + negatives.toString());
    }

    return sum;
  }
}